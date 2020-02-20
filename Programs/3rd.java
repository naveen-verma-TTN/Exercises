//Write a program to find the number of occurrences of a character in a string without using loop
class myClass {
    public static void main(String[] args) 
    { 
        String str = "ttttTnnTn$##3#"; 
        myClass obj = new myClass();
        obj.traverseChars(str,0,0); 
    }  

    public void traverseChars(String str, int ch, int i) {
        if(ch<255){
            traverseChars(str, ++ch, i);
        }
        int count = countOccurrences(str,(char)ch,0);
        if(count != 0)
        System.out.println("Count of " + (char)ch + ": " + count);
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