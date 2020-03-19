/*
    Write a program to find the number of occurrences of a character in a string without using loop.
 */
fun main(args: Array<String>) {
    val str = "tTnQtnt3tt#t20tt19"
    var ch = 't'
    val count = str.count { it == ch }
    println("$ch is occurs $count times") 
}
