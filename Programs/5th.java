import java.util.Scanner;

// Write a program to demonstrate wait and notify methods.

class Process{
    public void produce() throws InterruptedException {
        synchronized(this) {
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Resumed");
        }
    }

    public void consumer() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized(this){
            System.out.println("waiting for return key.");
            sc.nextLine();
            System.out.println("Return key pressed.");
            notify();
        }
    }
}

class myClass{
    public static void main(String[] args) {
        Process obj = new Process();
        Thread t1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
              try {
                  obj.produce();
              }
              catch(InterruptedException e) {
                  e.printStackTrace();
              }
            }
        });

        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
              try {
                  obj.consumer();
              }
              catch(InterruptedException e) {
                  e.printStackTrace();
              }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}