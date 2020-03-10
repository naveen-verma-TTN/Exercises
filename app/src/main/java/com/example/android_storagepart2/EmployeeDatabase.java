package com.example.android_storagepart2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Employee.class, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {

    private static EmployeeDatabase instance;

    public abstract EmployeeDao employeeDao();

    /**
     * setting up room - database
     */

    static synchronized EmployeeDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    EmployeeDatabase.class, "Employee_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    /**
     * Callback to populate random data
     */

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    /**
     * Populate random data to the database
     */

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private EmployeeDao employeeDao;

        private PopulateDbAsyncTask(EmployeeDatabase db) {
            this.employeeDao = db.employeeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            employeeDao.insert(new Employee("Kartik", "1234567890", "Delhi"));
            employeeDao.insert(new Employee("Romi", "2341573456", "Up"));
            employeeDao.insert(new Employee("Rishab", "2346464748", "Delhi"));
            employeeDao.insert(new Employee("Rani", "0238483823", "Chennai"));
            employeeDao.insert(new Employee("Shree", "2224546743", "Assam"));
            employeeDao.insert(new Employee("Rohan", "2346356753", "Bihar"));
            return null;
        }
    }
}
