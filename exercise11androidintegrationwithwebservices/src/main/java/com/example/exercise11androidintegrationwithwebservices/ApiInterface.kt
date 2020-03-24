package com.example.exercise11androidintegrationwithwebservices

import retrofit2.Call
import retrofit2.http.GET

/**
 * RetroFit ApiInterface for Network Request
 */
interface ApiInterface {
    @GET("posts.json")
    fun getData(): Call<MyData>
}