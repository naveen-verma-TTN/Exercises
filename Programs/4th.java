/*Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, 
Digits And Other Special Characters In A String*/
class myClass{
    public static void main(String args []) {
        String str = "tTn$Q3#2019";
        int count [] = {0,0,0,0};
        char []ch = str.toCharArray();
        for(char i : ch){
            if(i>=48 && i<=57) count[0]++;
            else if(i>=65 && i<=90) count[1]++;
            else if(i>=97 && i<=122) count[2]++;
            else count[3]++;
        }
        System.out.println("Number of digits in " + str +" is " + count[0] 
        + " which is " + 
        (count[0]*100.0/str.length())
        + " %");
        System.out.println("Number of Upper case in " + str +" is " + count[1] 
        + " which is " + 
        (count[1]*100.0/str.length())
        + " %");
        System.out.println("Number of Lower case in " + str +" is " + count[2] 
        + " which is " + 
        (count[2]*100.0/str.length())
        + " %");
        System.out.println("Number of Special Characters in " + str +" is " + count[3] 
        + " which is " + 
        (count[3]*100.0/str.length())+ 
        " %");
    }
}