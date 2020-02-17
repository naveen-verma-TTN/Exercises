// Write a program to find the number of occurrences of the duplicate words in a string and print them.
import java.io.*; 
import java.util.*;
class myClass {
    public static void main(String[] args) 
    { 
        String str = "hi i am a java + android developer"+ 
        " java is a used for developing android application" +
        " i love java"; 
        myClass obj = new myClass();
        obj.characterWords(str); 
    }  

    void characterWords(String s) 
    { 
        String [] strArray = s.split(" ");
        HashMap<String, Integer> count= new HashMap<String, Integer>(); 
  
        for (String c : strArray) { 
            if (count.containsKey(c)) { 
                count.put(c, count.get(c) + 1); 
            } 
            else { 
                count.put(c, 1); 
            } 
        } 
  
        for (Map.Entry i : count.entrySet()) { 
            System.out.print(i.getKey() + " -> " + i.getValue() + "\n"); 
        } 
    } 
   
} 