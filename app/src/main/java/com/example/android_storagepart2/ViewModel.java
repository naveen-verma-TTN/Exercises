package com.example.android_storagepart2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Employee_Repository repository;
    private LiveData<List<Employee>> allEmployees;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Employee_Repository(application);
        allEmployees = repository.getAllEmployees();
    }

     void insert(Employee employee) {
        repository.insert(employee);
    }

     void update(Employee employee) {
        repository.update(employee);
    }

     void delete(Employee employee) {
        repository.delete(employee);
    }

     LiveData<List<Employee>> getAllEmployees() {
        return allEmployees;
    }
}
