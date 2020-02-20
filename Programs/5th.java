/* Write a program to sort Employee objects based on highest salary using Comparator. 
Employee class{ Double Age; Double Salary; String Name
*/

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee {
    private int age;
    private double salary;
    private String name;
    public Employee(String name, Double salary, int age){
        this.age = age;
        this.salary = salary;
        this.name = name;
    }
    @Override
    public String toString() {
        return " {name: " + name + " age: " + age + " salary: " + salary + "}";
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
class myClass {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("Simi", 4534.45, 28));
        list.add(new Employee("Nitin", 9424.25, 25));
        list.add(new Employee("Rahul", 7534.00, 24));
        list.add(new Employee("Rohit", 8534.00, 26));
        list.add(new Employee("Naveen", 10424.45, 25));
        list.add(new Employee("Richa", 5534.00, 27));
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -o1.getSalary().compareTo(o2.getSalary());
            }
        });
        for(Employee values : list) {
            System.out.println(values);
        }
    }
}