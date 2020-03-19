/*
    Check letter in string which do not have pair.
 */

 fun main(args : Array<String>) {
    var s1 = "abccdcirrbc"
    var arr = s1.toCharArray()

    val map = HashMap<Char, Int>()

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
        if(map[c]!! %2 != 0)
            println("'$c'" + " doesn't have a pair")
    }
}