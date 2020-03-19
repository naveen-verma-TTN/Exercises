/*
    Find common elements between two arrays.
 */

 import java.util.*

 fun main(args: Array<String>) {
     val a1 = arrayOf(1,2,5,4,7,6,9,3)
     val a2 = arrayOf(2,5,3,7,4)

     println("First Array: " + Arrays.toString(a1))
     println("Second Array: " + Arrays.toString(a2))

     val iArray = a1.intersect(a2.toList()).toIntArray()

     println("Intersection: " + Arrays.toString(iArray))
 }