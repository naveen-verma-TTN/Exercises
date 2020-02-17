// Write a program to replace a substring inside a string with other string
class myClass {
    public static void main(String[] args) { 
        String str = "hi i am a java + android developer"; 
        String key = "java";
        String rStr = "kotlin";
        myClass obj = new myClass();
        obj.replaceString(str, key, rStr); 
    }  

    void replaceString(String main, String key, String rs) { 
        String [] strArray = main.split(" ");
        String newStr = new String();

          for(int i=0 ; i< strArray.length ; i++) {
              if (strArray[i].equals(key)) { 
                newStr += rs + " ";
            } 
              else { 
                  newStr += strArray[i] + " ";
            } 
        }

        System.out.println("Original String: " + main.toString());
        System.out.println("Replaced String: " + newStr);
    } 
} 