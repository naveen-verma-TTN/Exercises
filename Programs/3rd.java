//Write a program to find the number of occurrences of a character in a string without using loop
class myClass {
    public static void main(String[] args) 
    { 
        String str = "ttttTnnTn$##3#"; 
        char a = 't';
        myClass obj = new myClass();
        System.out.println("Count: " +obj.countOccurrences(str,a,0)) ; 
    }  

    public int countOccurrences(String str, char ch, int i){
         if((i=str.indexOf(ch, i)) == -1){
             return 0;
         }
        else {
            return (1+countOccurrences(str, ch, i+1));
        }
    }
} 