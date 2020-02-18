// WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
class myClass {
    public static void main(String[] args)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
