//Write a method that takes a string and returns the number of unique characters in the string.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class myClass {
    public int uniqueCharacters(String s)
    {
        int val;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int count=0;
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

        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            int m = entry.getValue();
            if(m==1){
                count++;
            }
        }
    return count;
    }
    public static void main(String[] args) {
        myClass obj = new myClass();
        int ctr = obj.uniqueCharacters("mananq");
        System.out.println("unique character count:"+ctr);

    }
}
