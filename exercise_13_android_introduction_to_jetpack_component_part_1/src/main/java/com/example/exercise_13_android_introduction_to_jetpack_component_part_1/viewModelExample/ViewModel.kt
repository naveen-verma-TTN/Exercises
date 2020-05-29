package com.example.exercise_13_android_introduction_to_jetpack_component_part_1.viewModelExample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel class
 */
class ViewModel : ViewModel() {
    private val colorValue =
        MutableLiveData<String>()

    fun setColor(color : String) {
        colorValue.value = color
    }

    fun getColor(): LiveData<String?> {
        return colorValue
    }
}