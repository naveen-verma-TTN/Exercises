package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.second_question.model

import com.google.gson.annotations.SerializedName

/**
 * Model Class
 */

class MyColor(

    @SerializedName("list")
    val list: List<ColorList>

)

data class ColorList(

    @SerializedName("code")
    val code: String,

    @SerializedName("name")
    val name: String

)

