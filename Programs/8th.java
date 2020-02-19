// Write a program to demonstrate the use of semaphore.

import java.util.concurrent.*; 
   
  
class myThread extends Thread 
{ 
    public static int count = 0; 
    Semaphore s; 
    String tName; 
    public myThread(Semaphore s, String tName)  
    { 
        super(tName); 
        this.s = s; 
        this.tName = tName; 
    } 
  
    @Override
    public void run() { 
          
        if(this.getName().equals("Thread A")) 
        { 
            System.out.println("Starting " + tName); 
            try 
            { 
               
                System.out.println(tName + " is waiting for a permit."); 
              
                s.acquire(); 
              
                System.out.println(tName + " gets a permit."); 
          
                for(int i=0; i < 5; i++) 
                { 
                    count++; 
                    System.out.println(tName + ": " + count); 
          
                    Thread.sleep(10); 
                } 
            } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                } 
          
                System.out.println(tName + " releases the permit."); 
                s.release(); 
        } 
          
        else
        { 
            System.out.println("Starting " + tName); 
            try 
            { 
                System.out.println(tName + " is waiting for a permit."); 
              
                s.acquire(); 
              
                System.out.println(tName + " gets a permit."); 
          
                for(int i=0; i < 5; i++) 
                { 
                    count--; 
                    System.out.println(tName + ": " + count); 
          
                    Thread.sleep(10); 
                } 
            } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                } 
                System.out.println(tName + " releases the permit."); 
                s.release(); 
        } 
    } 
} 

class myClass  
{ 
    public static void main(String args[]) throws InterruptedException  
    { 
        Semaphore sem = new Semaphore(1); 
          
        myThread t1 = new myThread(sem, "Thread 1"); 
        myThread t2 = new myThread(sem, "Thread 2"); 
          
        t1.start(); 
        t2.start(); 
          
        t1.join(); 
        t2.join(); 
          
        System.out.println("count: " + myThread.count); 
    } 
} 