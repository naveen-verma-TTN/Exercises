package adds.naveen.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // TextChangedListener for validating the zipcode
        zipcode.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(edit: Editable?) {
                val zipCode = edit.toString()
                if (zipCode.length == 5) {
                    getWeatherForZipCode(zipCode.toInt())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        // refresh button to refresh the weather
        refresh.setOnClickListener {
            val zipCode = zipcode.text.toString()
            if (zipCode.length == 5) {
                getWeatherForZipCode(zipCode.toInt())
            }
        }
    }


    /**
     * Retrofit request method
     */
    fun getWeatherForZipCode(ZipCode: Int) {
        val network = WeatherNetworkClient(applicationContext)
        val call = network.getWeatherForZipCode(zipCode = ZipCode)
        call.enqueue(object : Callback<Weather> {
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>?) {
                val weather: Weather? = response?.body()
                val main = weather?.main
                main?.let { presentData(it) }
            }
        })
    }

    /**
     * function to Update the UI
     */
    @SuppressLint("SetTextI18n")
    private fun presentData(main: Main?) {
        with(main) {
            currentTemp.text = "${this?.temp}°"
            lowTemp.text = "Low ${this?.temp_min}°"
            maxTemp.text = "High  ${this?.temp_max}°"
        }
    }
}
