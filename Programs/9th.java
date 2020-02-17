// Write a program to display values of enums using a constructor & getPrice() method (Example display house & their prices)

enum House{  
    WEALDEN_HALL_HOUSE(150000), SADDLEBAG(27000), DOGTROT_HOUSE(3800000), SHOTGUN_HOUSE(450000);  
    private int price;  
    House(int price){  
    this.price = price;  
    }  

    int getPrice(){
        return price;
    }
}
class myClass {
    public static void main(String [] args) {
        for(House h : House.values())
        System.out.println(h + " " + h.getPrice());
    }
}