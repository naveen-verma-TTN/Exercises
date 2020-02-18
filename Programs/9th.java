/* Design classes having attributes for furniture where there are wooden chairs 
and tables, metal chairs and tables. There are stress and fire tests for each products.
*/
interface Furniture {
    boolean stressTest = false;
    boolean fireTest = false;
    void testPassed();
}

interface Wooden extends Furniture{
  boolean stressTest = true;
  boolean fireTest = false;
}

interface Metal extends Furniture{
    boolean stressTest = true;
    boolean fireTest = true;
}

class Tables implements Wooden, Metal {
    @Override
    public void testPassed() {
        System.out.println("table");
        System.out.println("stress test for wooden: " + Wooden.stressTest);
        System.out.println("stress test for metal: " + Metal.stressTest);
        System.out.println("fire test for wooden: " + Wooden.fireTest);
        System.out.println("fire test for metal: " + Metal.fireTest);
    }
}

class Chair implements Wooden, Metal {
    @Override
    public void testPassed() {
        System.out.println("chair");
        System.out.println("stress test for wooden: " + Wooden.stressTest);
        System.out.println("stress test for metal: " + Metal.stressTest);
        System.out.println("fire test for wooden: " + Wooden.fireTest);
        System.out.println("fire test for metal: " + Metal.fireTest);
    }
}

class myClass {
    public static void main(String [] args) {
        Tables table = new Tables();
        table.testPassed();
        Chair chair = new Chair();
        chair.testPassed();
    }
}