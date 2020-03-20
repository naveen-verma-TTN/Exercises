/*
 Write a program to print your Firstname,LastName & age using init block,companion object.
*/

class Person(firstName : String, lastName : String){
    val firstName : String
    val lastName : String

    // companion object
     companion object {
        const val age : Int = 15
    }

    // init block
    init {
        this.firstName = firstName
        this.lastName = lastName
    }

}

  fun main(args: Array<String>) {
        var person = Person("Rahul", "Kumar")
        println("${person.firstName} ${person.lastName} is ${Person.Companion.age} year old.")
    }