// Write a program to demonstrate sleep and join methods.

class myThread extends Thread{  
 public void run(){  
  for(int i=1 ; i<=5; i++){  
   try{  
    Thread.sleep(500);  
   }
   catch(Exception e){System.out.println(e);}  
   System.out.println(this.getName() + " " + i);  
  }  
 }  
public static void main(String args[]){  
    myThread t1=new myThread();  
    myThread t2=new myThread();  
    myThread t3=new myThread();  
    t1.start();  
    try{
        t1.join();  
    }
    catch(Exception e){System.out.println(e);}  
    t2.start();  
    t3.start();  
    }  
}  