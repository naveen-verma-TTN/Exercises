/* 
WAP to create sealed Base class and 3 subclasses of Base class, write a 
function which will have base class object as an argument and it will 
return name of the subclass based argument type.
*/

// Sealed class
sealed class Base{
    class A : Base()
    class B : Base()
    class C : Base()
}


fun objectName(base : Base) : String{
    return when(base){
        is Base.A -> "A"
        is Base.B -> "B"
        is Base.C -> "C"
    }
}

fun main(args: Array<String>) {
    println("Class Name: " + objectName(Base.A()))
    println("Class Name: " + objectName(Base.B()))
    println("Class Name: " + objectName(Base.C()))
}