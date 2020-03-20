/*
    Write a program to create mutable list of Integer. replace the 
    second item in the list with new value. Print the list value.
*/

fun main(args: Array<String>) {
    var list = mutableListOf<Int>(1,2,3,4,5,6,7,8)
    println("List before change: " + list)

    list[1] = 9

    println("List After change: " + list)
}