// WAP showing try, multi-catch and finally blocks.
class myClass {
    public static void main(String [] args) {
        int num[] = new int[5];
        for( int i=0; i<5; i++) {
            num[i] = i;
        } 

        try {
            System.out.println(num[5]);
        }
        catch(ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        catch(Exception e){
            System.out.println("Exception");
        }
        finally{
            System.out.println("finally");
        }

    }
}