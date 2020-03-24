package com.example.exercise11androidintegrationwithwebservices

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * POJO Class / Model Class
 */

@Parcelize
class MyData(

    @SerializedName("posts")
    val posts: List<Posts>

) : Parcelable

@Parcelize
data class Posts(

    @SerializedName("name")
    val name: String,

    @SerializedName("message")
    val message: String,

    @SerializedName("profileImage")
    val profileImage: String

) : Parcelable

