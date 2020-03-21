/*
WAP to create singleton class.
 */

 object MyClass {
     fun message(){
         print("Hello from singleton class")
     }
 }

 fun main(args: Array<String>) {
     MyClass.message()
 }