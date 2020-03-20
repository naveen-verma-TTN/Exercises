/*
    Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails 
     which provide there specific details like rateofinterest etc,print details of every bank.
*/

open class Bank(name : String, rateofinterest : Double) {
    private var name : String
    private var rateofinterest : Double

    init {
        this.name = name
        this.rateofinterest = rateofinterest
    }

    open fun getDetails() {
        println("Bank Name: $name, Rate Of Interest: $rateofinterest")
    }
}

/** 
    SBI inherits Bank
**/

class SBI(name : String, rateofinterest : Double): Bank(name, rateofinterest) {
    private var name : String
    private var rateofinterest : Double

    init {
        this.name = name
        this.rateofinterest = rateofinterest
    }

    override fun getDetails() {
        println("Bank Name: $name, Rate Of Interest: $rateofinterest")
    }
}

/** 
    BOI inherits Bank
**/

class BOI(name : String, rateofinterest : Double): Bank(name, rateofinterest) {
    private var name : String
    private var rateofinterest : Double

    init {
        this.name = name
        this.rateofinterest = rateofinterest
    }

    override fun getDetails() {
        println("Bank Name: $name, Rate Of Interest: $rateofinterest")
    }
}

/** 
    ICICI inherits Bank
**/

class ICICI(name : String, rateofinterest : Double): Bank(name, rateofinterest) {
    private var name : String
    private var rateofinterest : Double

    init {
        this.name = name
        this.rateofinterest = rateofinterest
    }

    override fun getDetails() {
        println("Bank Name: $name, Rate Of Interest: $rateofinterest")
    }
}

/** 
    main block
**/

fun main(args: Array<String>) {
    var rbi = Bank("RBI",4.5)
    rbi.getDetails()
    var sbi = SBI("SBI",3.2)
    sbi.getDetails()
    var boi = BOI("BOI",5.2)
    boi.getDetails()
    var icici = ICICI("ICICI",7.4)
    icici.getDetails()
}