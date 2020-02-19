// Write a program to create a thread using Thread class and Runnable interface each.

class A extends Thread{
    @Override
    public void run(){
        for(int i= 0 ; i<5; i++) {
            try{
                Thread.sleep(1000);
                System.out.println(this.getName());
            }
            catch(InterruptedException e){
                e.getStackTrace();
            }
            
        }
    }
}
class B implements Runnable {
    @Override
    public void run(){
        for(int i= 0 ; i<5; i++) {
            try{
                Thread.sleep(1000);
                System.out.println(this.getName());
            }
            catch(InterruptedException e){
                e.getStackTrace();
            }
        }
    }
}

class myClass {
    public static void main(String [] args){
        Thread t1 = new Thread(new A());
        t1.setName("thread 1");
        t1.start();

        A t2 = new A();
        t2.setName("thread 2");
        t2.start();
    }
}