/* Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), 
isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. 
(Expected complexity -O(1))
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class SpecialStack extends Stack<Integer>
{
    SupportStack s;

    public SpecialStack(int n) {
        super();
        s = new SupportStack(n);
    }

   // @Override
    public Object push(int item) {

        if(s.isEmpty())
            s.push(item);
        if(item < s.lastElement())
            s.push(item);
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {

        if(s.contains(this.lastElement()))
            s.pop();
        return super.pop();
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    @Override
    public synchronized int search(Object o) {
        return super.search(o);
    }


    public int getMin()
    {
        return (int)s.lastElement();
    }


}

class SupportStack extends Stack<Integer>
{
    public SupportStack(int n) {
        super();
    }

    @Override
    public Integer push(Integer item) {
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        return super.pop();
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    @Override
    public synchronized int search(Object o) {
        return super.search(o);
    }
}


public class Q8
{
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the size of the stack");
        int n = obj.nextInt();
        SpecialStack stack = new SpecialStack(n);

        int ch;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Push\n2. Pop\n3. Check if empty\n4. Check if full\n5. Check the minimum element in the stack.\n" +
                    "Press 6 to exit.");

            ch = obj.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.println("Enter the Element: ");
                    int d = obj.nextInt();
                    stack.push(d);
                    break;

                case 2:
                    int x = stack.pop();
                    System.out.println(x);
                    break;

                case 3:
                    stack.isEmpty();
                    break;

                case 4:
                    if(stack.size() == 20)
                        System.out.println("Stack full");
                    else
                        System.out.println("Not yet full.");
                    break;

                case 5:
                    System.out.println(stack.getMin());
                    break;

            }

        }while(ch != 6);
    }
}
