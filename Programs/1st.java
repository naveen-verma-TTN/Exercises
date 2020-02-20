/* Write Java code to define List . Insert 5 floating point numbers in List, 
and using an iterator, find the sum of the numbers in List.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


class myClass {
    public static void main(String[] args) {
        List<Float> list = new ArrayList<Float>();
        list.add(12.34F);
        list.add(23.43F);
        list.add(14.23F);
        list.add(32.4F);
        list.add(56.21F);
        float sum = 0;
        ListIterator<Float> iterator = list.listIterator();
        while(iterator.hasNext()){
            sum += iterator.next(); 
        }
        System.out.println("Sum: " + sum);
    }
}