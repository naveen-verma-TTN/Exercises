/*
Write a function which take marks as an argument and return the the grade as follows:
    1. marks between 50 to 60 , return “Good”
    2. marks between 60 to 70, return “Very Good”
    3. marks between 70 to  80, return “Excellent”
    4. marks between  80 to 100, return “Rockstar”
*/


fun grade(_marks : Double): String {
    var marks = Math.round(_marks)
    return when(marks) {
        in 0..50 -> "fail"
        in 50..60 -> "Good"
        in 60..70 -> "Very Good"
        in 70..80 -> "Excellent"
        in 80..100 -> "Rockstar"
        else -> "Invaild marks"
    }
}

fun main(args: Array<String>) {
    print("Grade: " + grade(82.5))
}