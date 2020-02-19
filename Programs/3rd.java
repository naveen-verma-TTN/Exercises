// Write a program using synchronization block and synchronization method

class myClass {
    private int count = 0;


    // locking objects 
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public static void main(String[] args) {
        myClass obj = new myClass();
        obj.doSomeWork();
    }

    // synchronized method
    public synchronized void increment(){
        count++;
    }

    // synchronized blocks
    void stageOne() {
        synchronized(obj1){
            try{
                Thread.sleep(10);
                System.out.println("Thread 3 working");
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            count++;
        }
    }

    void stageTwo() {
        synchronized(obj2){
            try{
                Thread.sleep(10);
                System.out.println("Thread 4 working");
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            count++;
    }
}
   

    public void doSomeWork() {
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Thread 1 working");
                for(int i= 0 ; i< 500 ; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Thread 2 working");
                for(int i= 0 ; i< 500 ; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
        System.out.println("count " +count);


        for(int i=0; i<5 ; i++ ){
            stageOne();
            stageTwo();
        }

        System.out.println("count " +count);
    }
}