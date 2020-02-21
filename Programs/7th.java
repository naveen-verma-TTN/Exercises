/* Print the elements of an array in the decreasing frequency if 2 numbers have same frequency 
then print the one which came first.
*/

import java.util.*;

class myClass {
    public static HashMap<Integer, Integer> sortByValue(TreeMap<Integer, Integer> hm) {
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });


        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        int array[] = new int[]{2, 4, 6, 7, 6, 8, 1, 2};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                int val = map.get(i);
                val = val + 1;
                map.put(i, val);
            } else {
                map.put(i, 1);
            }
        }
        Map<Integer, Integer> hm1 = sortByValue(map);

        for(Map.Entry<Integer,Integer> e : hm1.entrySet())
        {
            System.out.println("key: "+e.getKey()+" "+e.getValue());
        }

        }
    }

