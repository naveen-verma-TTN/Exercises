/* Write a program to create a Thread pool of 2 threads where one 
Thread will print even numbers and other will print odd numbers.
*/

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class Even implements Runnable{
    int num = 1;
    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            if(num % 2 == 0) {
                System.out.println("thread 1 " +num);
            }
            num++;
    }
}
}

class Odd implements Runnable{
    int num = 1;
    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            if(num % 2 != 0) {
                System.out.println("thread 2 " +num);
            }
            num++;
    }
}
}


class myClass {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

            executor.submit(new Even());
            executor.submit(new Odd());

        executor.shutdown();
    }
}