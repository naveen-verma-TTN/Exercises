/* WAP to read words from the keyboard until the word done is entered.
 For each word except done, report whether its first character is equal to its last character. 
 For the required loop, use a
a)while statement
b)do-while statement
*/
import java.util.Scanner;
class demo {
    public static void main(String args[]){
        String input = new String();
        Scanner scanner = new Scanner(System.in);
        do{
            input = scanner.nextLine();
            System.out.println("Input: " + input);
            char c[] = new char[input.length()];
            c = input.toCharArray();
            int i = 0;
            while(i < c.length)  {
                if(i == (c.length - 1) && c[0] == c[i]){
                    System.out.println("first character is equal to its last character");
                }
                i++;
            }
        }while(!input.equalsIgnoreCase("done"));
        scanner.close();
    }
}