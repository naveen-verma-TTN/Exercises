package com.example.exercise11androidintegrationwithwebservices

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MyDataClass {
    data class MyData(
        @Expose
        @SerializedName("posts")
        val posts: Posts
    )

    data class Posts(
        @Expose
        @SerializedName("name")
        val name: String,
        @Expose
        @SerializedName("message")
        val message: String,
        @Expose
        @SerializedName("profileImage")
        val profileImage: String
    )
}
