// WAP to show object cloning in java using cloneable and copy constructor both.
class myClone implements Cloneable{
    private int a;

    public myClone(){
    }

    // copying the members of the class using other object..
    public myClone(myClone obj){
        this.a = obj.a;
    }
    public void setStr(int a){
        this.a = a;
    }
    public void display(){
        System.out.println("The String is "+a);
    }

    @Override
    protected Object clone(){
        try{
        return super.clone();
        }
        catch(Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
class myClass {
    public static void main(String [] args) {
        myClone obj1 = new myClone();
        obj1.setStr(2);
        obj1.display();
        myClone obj2 = new myClone(obj1);
        obj2.display();
        myClone obj3 = (myClone)obj2.clone();
        obj3.display();
    }
}