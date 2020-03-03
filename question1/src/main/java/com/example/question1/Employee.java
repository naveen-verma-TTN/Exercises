package com.example.question1;


class Employee {
    private int id;
    private String name;

    int getId() {
        return id;
    }

    private String address;
    private String phone;

    Employee(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    String getName() {
        return name;
    }

    String getAddress() {
        return address;
    }

    String getPhone() {
        return phone;
    }

}
