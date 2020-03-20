/*
Write a program to create mutable map. print all the value and key of map.
*/

fun main(args: Array<String>) {
    var map = mutableMapOf<String,String>("Name" to "Rahul","Age" to "25","Gender" to "Male")

    for(v in map) {
        println("Key: {${v.key}}, value: {${v.value}}")
    }
}