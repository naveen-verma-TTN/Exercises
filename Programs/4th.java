// Write a program to sort HashMap by value.

import java.util.*;

class myClass {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });


        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        int val;
        map.put("naveen",101);
        map.put("neha",62);
        map.put("rahul",1001);
        map.put("shyam",897);
        map.put("reena",3);

        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println(en.getKey() +
                    " : " + en.getValue());
        }
    }
}
