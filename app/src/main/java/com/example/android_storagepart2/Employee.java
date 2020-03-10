package com.example.android_storagepart2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee_table")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "employee_name")
    private String name;

    @ColumnInfo(name = "employee_phone")
    private String phone;

    @ColumnInfo(name = "employee_address")
    private String address;

    public Employee(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    String getAddress() {
        return address;
    }
}
