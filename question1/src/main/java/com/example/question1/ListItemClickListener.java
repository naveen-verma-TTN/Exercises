package com.example.question1;

import java.util.ArrayList;
import java.util.List;

public interface ListItemClickListener {

    public List<Employee> fetchData();

    public void onDelete(Employee employee, int position);

    public void onEdit(Employee employee, int position);
}
