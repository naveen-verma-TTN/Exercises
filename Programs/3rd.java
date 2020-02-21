// Write a method that takes a string and print the number of occurrence of each character characters in the string.

import java.util.HashMap;

class myClass {
    public static void main(String[] args) {
        String s = "pashuram";
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int val;
        char ch [] = s.toCharArray();
        for (char c : ch) {
            if(map.containsKey(c))
            {
                val = map.get(c);
                val = val + 1;
                map.put(c,val);
            }
            else
            {
                map.put(c,1);
            }
        }
        System.out.println(map);
    }
}