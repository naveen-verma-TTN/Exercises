package com.example.question1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "employee";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_Address = "address";
    private static final String KEY_Phone = "phone";

    DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = new String("CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_NAME + " TEXT, "
                + KEY_Address + " TEXT, "
                + KEY_Phone + " TEXT" + ")");
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(new String("DROP TABLE IF EXISTS " + TABLE_NAME));
        onCreate(db);
    }

    void addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, employee.getName());
        values.put(KEY_Address, employee.getAddress());
        values.put(KEY_Phone, employee.getPhone());
        long insertedID = db.insert(TABLE_NAME, null, values);
//        Log.d("DB", "-------Inserted ID:" + insertedID);
        db.close();
    }

    List<Employee> getDetailsAll() {
        List<Employee> employeeList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_Address, KEY_Phone}, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Employee employee = new Employee(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                employeeList.add(employee);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return employeeList;
    }

    void deleteEmployee(int employeeID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Object o = db.delete(TABLE_NAME,
                KEY_ID + "=? ",
                new String[]{String.valueOf(employeeID
                )});
        Log.e("ID deleted ", String.valueOf(employeeID));
        db.close();
    }

    void updateEmployee(int employeeID) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, "--------");
        values.put(KEY_Address, "---------");
        values.put(KEY_Phone, "-----------");

        db.update(TABLE_NAME, values, KEY_ID + " =? "
                , new String[]{String.valueOf(employeeID)});
    }
}
