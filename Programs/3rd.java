//Write a program to find the number of occurrences of a character in a string without using loop
class myClass {
    public static void main(String[] args) 
    { 
        String str = "t t t t T n n T n $ # # 3 #"; 
        myClass obj = new myClass();
        System.out.println("Count: " +obj.countOccurrences(str,' ',0)) ; 
    }  

    public int countOccurrences(String str, char ch, int i){
        return ((i=str.indexOf(ch, i)) == -1)?0:1+countOccurrences(str, ch, i+1);}
} 