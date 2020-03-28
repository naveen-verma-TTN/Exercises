package adds.naveen.weatherapp

import android.content.Context
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * ApiClient class
 */
class WeatherNetworkClient(context: Context) {
    private val apiKey = context.resources.getString(R.string.api_key)
    private val url = "https://api.openweathermap.org/data/2.5/"

    fun getWeatherForZipCode(zipCode: Int): Call<Weather> {
        val network = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val weatherServices = network.create(WeatherService::class.java)
        return weatherServices.weatherByZip(
            "metric", zipCode,
            apiKey
        )
    }

}