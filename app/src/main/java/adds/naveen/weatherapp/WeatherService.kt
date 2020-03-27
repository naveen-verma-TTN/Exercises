package adds.naveen.weatherapp

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * interface for network request
 */
interface WeatherService {
    @GET("/data/2.5/weather")
    fun weatherByZip(@Query("units") units: String, @Query("zip") zip: Int, @Query("Appid") apikey: String): retrofit2.Call<Weather>
}