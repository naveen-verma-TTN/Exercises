package adds.naveen.weatherapp

/**
 * Pojo class / Model class
 */
open class Weather {
    var main: Main = Main()
    var name : String = ""
}

class Main {
    var temp: Double = 0.0
    var temp_min: Double = 0.0
    var temp_max: Double = 0.0
}