/* Write a program to find the number of occurrences of the duplicate words in a 
    string and print them.
*/

fun main(args : Array<String>) {
    var s1 = "hello this is kotlin language . kotlin language is new java language"
    var arr = s1.split(" ")

    val map = HashMap<String, Int>()

    for(i in arr){
        if(map.keys.contains(i)) {
            var x = map[i]
            map[i] = 1+(x?:0)
        }
        else{
            map[i] = 1
        }
    }

    for(c in map.keys){
        if(map[c]!! > 1)
            println(c + " repeates " + map[c] + " times.")
    }
}