/*
Write a single program for following operation using overloading
  A) Adding 2 integer number
  B) Adding 2 double
  D) multiplying 2 int
  E) concate 2 string
  F) Concate 3 String

*/

class MyClass{

    // Adding 2 integer number
    fun operation1(num1 : Int, num2 : Int){
        println("$num1 + $num2 = ${num1+num2}")
    }

    // Adding 2 double
    fun operation1(num1 : Double, num2 : Double){
        println("$num1 + $num2 = ${num1+num2}")
    }

    // multiplying 2 int
    fun operation2(num1 : Int, num2 : Int){
        println("$num1 x $num2 = ${num1*num2}")
    }
    // concate 2 string
    fun operation3(s1 : String, s2 : String){
        println(s1 + " " + s2)
    }
    // Concate 3 String
     fun operation3(s1 : String, s2 : String, s3 : String){
        println(s1 +" " +  s2 + " " + s3)
    }
}

fun main(args: Array<String>) {
    var obj = MyClass()
    obj.operation1(1,4)
    obj.operation1(1.0,4.0)
    obj.operation2(1,4)
    obj.operation3("Android", "Java")
    obj.operation3("Android", "Kotlin", "Java")
}