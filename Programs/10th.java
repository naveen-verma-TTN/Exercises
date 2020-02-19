import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Write a program which creates deadlock between 2 threads

class myThread {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private int count = 0;

    public void firstThread() throws InterruptedException{
        for(int i=0 ; i<1000; i++) {
            try{

                // deadlock occurs at this point.... as lock1 is locked is firstThread
                lock1.lock();
                lock2.lock();
                count++;
            }
            finally{
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException{
        for(int i=0 ; i<1000; i++) {
            try{

                // deadlock occurs at this point.... as lock2 is locked is secondThread
                lock2.lock();
                lock1.lock();
                count++;
            }
            finally{
                lock1.unlock();
                lock2.unlock();
            }
        }
        
    }

    public void finished() {
        System.out.println("Count " + count);
    }
}

class myClass {
    public static void main(String[] args) {
        final myThread obj = new myThread();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    obj.firstThread();
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
                    obj.secondThread();
                } 
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        obj.finished();
    }

}
