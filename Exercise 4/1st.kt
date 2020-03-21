/*
    WAP using Lambda function to calculate the Simple Interest. 
*/

fun main(args: Array<String>) {
    var simpleInterest = { principle : Int, rate : Double, time : Double -> 
        principle * rate * time
    }
    print("Simple Interest : " + simpleInterest(2000, 2.3, 3.5))
}