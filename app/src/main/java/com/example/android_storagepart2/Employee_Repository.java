package com.example.android_storagepart2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

class Employee_Repository {
    private EmployeeDao employeeDao;
    private LiveData<List<Employee>> allEmployees;

    Employee_Repository(Application application) {
        EmployeeDatabase database = EmployeeDatabase.getInstance(application);
        employeeDao = database.employeeDao();
        allEmployees = employeeDao.getAllEmployees();
    }

    /**
     * Insert employee
     */

    void insert(Employee employee) {
        new InsertEmployeeAsyncTask(employeeDao).execute(employee);
    }

    /**
     * Update employee
     */

    void update(Employee employee) {
        new UpdateEmployeeAsyncTask(employeeDao).execute(employee);
    }

    /**
     * delete employee
     */

    void delete(Employee employee) {
        new DeleteEmployeeAsyncTask(employeeDao).execute(employee);
    }

    /**
     * Return all employee
     */

    LiveData<List<Employee>> getAllEmployees() {
        return allEmployees;
    }

    /**
     * Insert employee AsyncTask
     */

    private static class InsertEmployeeAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao employeeDao;

        private InsertEmployeeAsyncTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.insert(employees[0]);
            return null;
        }
    }

    /**
     * Update employee AsyncTask
     */

    private static class UpdateEmployeeAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao employeeDao;

        private UpdateEmployeeAsyncTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.update(employees[0]);
            return null;
        }
    }

    /**
     * Delete employee AsyncTask
     */

    private static class DeleteEmployeeAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao employeeDao;

        private DeleteEmployeeAsyncTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.delete(employees[0]);
            return null;
        }
    }
}
