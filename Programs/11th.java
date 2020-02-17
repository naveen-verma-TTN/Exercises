/* Create 3 sub class of bank SBI,BOI,ICICI all 4 should have 
method called getDetails which provide there specific details like 
rateofinterest etc,print details of every banks
*/
class Bank {
    private String bankId = "RBI57475";
    private String bankName = "Reserve Bank Of India";
    private double rateofinterest = 16.15;

    public void getDetails(){
        System.out.println("ID: " + bankId);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Rate of Interest: " + rateofinterest);
    }

    // SBI class

    class SBI {
        private String bankId = "SBI12345";
        private String bankName = "State Bank Of India";
        private double rateofinterest = 12.45;

        public void getDetails(){
            System.out.println("ID: " + bankId);
            System.out.println("Bank Name: " + bankName);
            System.out.println("Rate of Interest: " + rateofinterest);
        }
    }
    
    // BOI class

    class BOI {
        private String bankId = "BOI18436";
        private String bankName = "Bank Of India";
        private double rateofinterest = 10.48;

        public void getDetails(){
            System.out.println("ID: " + bankId);
            System.out.println("Bank Name: " + bankName);
            System.out.println("Rate of Interest: " + rateofinterest);
        }
    }

    // ICICI class 
    
    class ICICI {
        private String bankId = "ICICI87463";
        private String bankName = "ICICI Bank";
        private double rateofinterest = 15.05;

        public void getDetails(){
            System.out.println("ID: " + bankId);
            System.out.println("Bank Name: " + bankName);
            System.out.println("Rate of Interest: " + rateofinterest);
        }
    }
}

class myClass {
    public static void main(String args []){
    Bank bank = new Bank();
    bank.getDetails();  
    System.out.println();
    Bank.SBI sbi = bank.new SBI();
    sbi.getDetails();  
    System.out.println();
    Bank.BOI boi = bank.new BOI();
    boi.getDetails(); 
    System.out.println();
    Bank.ICICI icici = bank.new ICICI();
    icici.getDetails();   
    }
}