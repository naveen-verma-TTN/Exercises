// Write a program to demonstrate the use of CountDownLatch

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Process implements Runnable{
    private CountDownLatch latch;
    public Process(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("Started..");

        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
class myClass {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor  = Executors.newFixedThreadPool(3);

        System.out.println("Remaining..." + latch.getCount());

        for(int i=0; i<3; i++) {
            executor.submit(new Process(latch));
        }

        try {
            latch.await();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Remaining..." + latch.getCount());

        executor.shutdown();
    }
}
