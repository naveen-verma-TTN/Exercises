/* Write a program to sort the Student objects based on Score , if the score are same then sort on First Name . 
Class Student{ String Name; Double Score; Double Age
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Student implements Comparable<Student>{
    private String name;
    private Double score;
    private int age;

    public Student(String name, double score, int age){
        this.name = name;
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student obj) {
        if(score > obj.score) {
            return -1;
        }
        else if(score < obj.score) {
            return 1;
        }
        else{
            return name.compareTo(obj.name);
        }
    }

    @Override
    public String toString() {
        return " {name: " + name + " age: " + age + " score: " + score + "}";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((score == null) ? 0 : score.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (score == null) {
            if (other.score != null)
                return false;
        } else if (!score.equals(other.score))
            return false;
        return true;
    }
    
}

class myClass {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("Nitin", 94.24, 25));
        list.add(new Student("Rahul", 75.34, 24));
        list.add(new Student("Simi", 45.34, 28));
        list.add(new Student("Rohit", 85.34, 26));
        list.add(new Student("Naveen", 94.24, 25));
        list.add(new Student("Richa", 55.34, 27));
        Collections.sort(list);
        for(Student values : list) {
            System.out.println(values);
        }
        
    }
}