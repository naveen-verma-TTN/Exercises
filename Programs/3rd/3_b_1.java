import temp.ex;
class myClass {
    public static void main(String[] args) {
        try {
            // NoClassDefFoundError
            ex obj = new ex();
        } catch (Exception t) {
            System.out.println(t);
        }
        ex obj2 = new ex();
    }
}