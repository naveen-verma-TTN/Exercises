package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ViewModel class
 */
class ColorViewModel: ViewModel() {
    companion object{
        private const val TAG  = "ColorViewModel"
    }

    // color value
    private val colorValue =
        MutableLiveData<ColorList>()

    // List of colors
    val colorList =
        MutableLiveData<List<ColorList?>>()

    /**
     * function to setColor
     */
    fun setColor(color : ColorList) {
        colorValue.value = color
    }

    /**
     * function to getColor
     */
    fun getColor(): LiveData<ColorList>? {
        return colorValue
    }

    init{
        downloadListUsingRetroFit()
    }

    /**
     * function to download the Json using RetroFit Api
     * and update the colorList
     */
    private fun downloadListUsingRetroFit() {
        val call: Call<MyColor> = ApiClient.getClient.getData()
        var data : MyColor? = null
        call.enqueue(object : Callback<MyColor> {
            override fun onResponse(call: Call<MyColor>?, response: Response<MyColor>?) {
                data = response!!.body()!!
                colorList.value = data!!.list
            }

            override fun onFailure(call: Call<MyColor>?, t: Throwable?) {
                Log.e(TAG, "Exception: " + t.toString())
            }
        })
    }
}