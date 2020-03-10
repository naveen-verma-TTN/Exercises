package com.example.android_storagepart2;

import java.util.ArrayList;
import java.util.List;

public interface ListItemClickListener {

    public void onDelete(Employee employee, int position);

    public void onEdit(Employee employee, int position);
}
