/*
    Create a list of Employee which w'ill have name and age as properties. 
     print the name of all employees age >30 
*/

class Employee(name :String, age : Int){
    val name : String
    val age : Int
    init {
        this.name = name
        this.age = age
    }
}

fun main(args: Array<String>) {
    var list = mutableListOf<Employee>(
        Employee("Rahul", 20),
        Employee("Shruti", 35),
        Employee("Shyam", 25),
        Employee("Ram", 45),
        Employee("Tarun", 52),
        Employee("Ravi", 40)
    )

    var list2 = list.filter{ it-> it.age > 30}

    for(employee in list2) {
        println("Employee: {Name: ${employee.name}, Age: ${employee.age}}")
    }
}
