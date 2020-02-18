// WAP to create singleton class.

class Singleton {

    private static Singleton singleton;
 
    private Singleton() { }
 
    public static Singleton getInstance( ) {
        if(singleton == null)   {
            return new Singleton( );
        }
       return singleton;
    }
 
    protected void show( ) {
       System.out.println("hi from singleton");
    }
 }

class SingletonDemo {
    public static void main(String[] args) {
       Singleton obj = Singleton.getInstance( );
       obj.show( );
    }
 }

