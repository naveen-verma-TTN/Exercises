/* Write a program to reverse a string and remove character 
from index 4 to index 9 from the reversed string using String Buffer */
class myClass {
    public static void main(String [] args) {
        String str = "naveen verma";
        char [] chArray = str.toCharArray();

        StringBuffer stringBuffer = new StringBuffer();
        for(int i = chArray.length - 1; i >= 0 ; i--) {
            stringBuffer.append(chArray[i]);
        }
        System.out.println("Original String: " + str);
        System.out.println("Reverse String: " + stringBuffer.toString());
        System.out.println("Modified String: " + stringBuffer.replace(4, 9, ""));
    }
}