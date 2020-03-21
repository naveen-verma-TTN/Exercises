/*
    WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
*/


fun main(args: Array<String>) {
   try
        {
            Class.forName("org.myPackage.Base");

        }catch (e: ClassNotFoundException )
        {
            print("Exception: " + e)
        }
    
}