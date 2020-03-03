/* Make an application with following features:
    1.Add Employee information like Name, Address, mobile number.
    2.Display all inserted record in RecyclerView and each item have edit and delete button.
    3.On delete button clicked - delete record from table and refresh list Data.
    4.On edit button clicked - update record in table and refresh list Data.
*/

package com.example.question1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListItemClickListener {
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "mydb";

    private myAdapter adapter;
    private DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = new DatabaseHandler(this, DATABASE_NAME,
                null, DATABASE_VERSION);

        // Comment after running the application for the first run
        addData(db);

        fetchData();

        setRecyclerView();
    }

    /**
     * setting Recycler view
     */

    public void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter = new myAdapter(this, this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * fetchData
     */

    public List<Employee> fetchData() {
        List<Employee> employees = db.getDetailsAll();

        for (Employee employee : employees) {
            String log = "id: " + employee.getId()
                    + " name: " + employee.getName()
                    + " Address: " + employee.getAddress()
                    + " Phone: " + employee.getPhone();
            Log.e("mm ", log);
        }
        return employees;
    }

    /**
     * adding dummy data
     */

    private void addData(DatabaseHandler db) {
        db.addEmployee(new Employee(1, "naveen", "rohini", "9100000000"));
        db.addEmployee(new Employee(2, "rahul", "mayur vihar", "9199999999"));
        db.addEmployee(new Employee(3, "sunny", "preet vihar", "9522222222"));
        db.addEmployee(new Employee(4, "Karthik", "rani bagh", "9533333333"));
    }

    /**
     * deletion operation
     */

    @Override
    public void onDelete(Employee employee, int position) {
        db.deleteEmployee(employee.getId());
        fetchData();
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, fetchData().size());
    }

    /**
     * update operation
     */

    @Override
    public void onEdit(Employee employee, int position) {
        db.updateEmployee(employee.getId());
        fetchData();
        adapter.notifyItemChanged(position);
    }
}
