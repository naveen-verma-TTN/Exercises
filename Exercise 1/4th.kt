/*
    Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And 
    Other Special Characters In A String.
 */

 fun main(args: Array<String>) {
      var str = "tTnQ3#2019"
        var count: Array<Int> = arrayOf(0,0,0,0,0)
        var ch = str.toCharArray()
        for(i in ch){
            var n = i.toInt()
            if(n>=48 && n<=57) count[0]++;
            else if(n>=65 && n<=90) count[1]++;
            else if(n>=97 && n<=122) count[2]++;
            else count[3]++;
        }
        println("Number of digits in $str is ${count[0]} which is " 
        + (count[0]*100.0/str.length) + " %");
        println("Number of Upper case in $str is ${count[1]} which is " 
        + (count[1]*100.0/str.length) + " %");
        println("Number of Lower case in $str is ${count[2]} which is " 
        + (count[2]*100.0/str.length) + " %");
        println("Number of Special Characters in $str is ${count[3]} which is " 
        + (count[3]*100.0/str.length) + " %");
 }