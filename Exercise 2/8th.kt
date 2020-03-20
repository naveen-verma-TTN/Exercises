/*
    Write a program to create HashSet. print all the value.
*/

fun main(args: Array<String>) {
    var hashSet = HashSet<Int>()
    hashSet.add(2)
    hashSet.add(4)
    hashSet.add(5)
    hashSet.add(3)
    hashSet.add(5) // not added in the list as 5 is already present in the list
    hashSet.add(6)

    for(element in hashSet){
        print(" $element ")
    }
}