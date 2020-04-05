package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.api

import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model.MyColor
import retrofit2.Call
import retrofit2.http.GET

/**
 * RetroFit ApiInterface for Network Request
 */
interface ApiInterface {
    @GET("351f9ec3d0391721c59e")
    fun getData(): Call<MyColor>
}