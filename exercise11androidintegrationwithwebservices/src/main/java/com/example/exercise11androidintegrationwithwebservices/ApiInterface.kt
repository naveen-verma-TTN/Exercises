package com.example.exercise11androidintegrationwithwebservices

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts.json")
    fun getData(): Call<MyDataClass>
}