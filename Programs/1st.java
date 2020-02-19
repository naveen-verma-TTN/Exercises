// Write a programe do to demonstrate the use of volatile keyword.

import java.util.*;
class A extends Thread{
    /* it will notify that the value of "running" can be changed at runtime
        and not should not retained the value from cache. 
    */
    private volatile boolean running = true;
    @Override
    public void run(){
        while(running) {
            try{Thread.sleep(500);
                System.out.println(" Running ");
            }
            catch(InterruptedException e){
                e.getStackTrace();
            }
            
        }
    }

    public void shutdown () {
        running = false;
    }
}
class myClass{
    public static void main(String [] args) {
        A t1 = new A();
        t1.start();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        t1.shutdown();
        sc.close();
    }
}