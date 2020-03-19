// Write a program to replace a substring inside a string with another string.

fun main(args : Array<String>) {

    var s1 : String = "this is java language!"

    var s2 = "kotlin"

    s2 = s1.replace("java",s2)
    
    print(s2)
}