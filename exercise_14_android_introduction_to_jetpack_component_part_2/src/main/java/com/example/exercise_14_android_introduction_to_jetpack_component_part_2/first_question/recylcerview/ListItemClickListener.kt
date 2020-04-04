package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.recylcerview

import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.model.User


/**
 * ClickListener Interface
 */
interface ListItemClickListener {
    fun onDeleteUser(user: User?)
    fun onUpdateUser(user: User?)
}