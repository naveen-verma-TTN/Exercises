package com.example.android_storagepart2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddUpdateItem extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_update_item);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);

        Intent intent = getIntent();
        if(intent.hasExtra("employeeId")){
            setTitle("Edit Employee");
            name.setText(intent.getStringExtra("employeeName"));
            phone.setText(intent.getStringExtra("employeePhone"));
            address.setText(intent.getStringExtra("employeeAddress"));
        }
        else {
            setTitle("Add Employee");
        }
    }

    /**
     * Save Employee detail to room database
     */

    private void saveEmployee() {
        String employeeName = name.getText().toString();
        String employeePhone = phone.getText().toString();
        String employeeAddress = address.getText().toString();

        if(employeeName.trim().isEmpty() || employeePhone.trim().isEmpty()
                || employeeAddress.trim().isEmpty()) {
            Toast.makeText(this,getString(R.string.item_error_message), Toast.LENGTH_LONG).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra("employeeName", employeeName);
        data.putExtra("employeePhone", employeePhone);
        data.putExtra("employeeAddress", employeeAddress);

        int employeeId = getIntent().getIntExtra("employeeId", -1);
        if(employeeId != -1) {
            data.putExtra("employeeId", employeeId);
        }
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save_employee) {
            saveEmployee();
            return true;
        }
        else if(item.getItemId() == R.id.cancel) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
