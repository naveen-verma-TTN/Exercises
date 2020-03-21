/* 
    WAP to create extension function.
*/

// Extension function
fun Int.add(num : Int): Int{
    return this + num
}

fun main(args: Array<String>) {
    var num1 = 1
    var num2 = 2
    print("$num1 + $num2 = " + num1.add(num2))
}