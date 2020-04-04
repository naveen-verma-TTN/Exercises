package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.model.User

/**
 * UserDao interface
 */
@Dao
interface UserDao {
    @Insert
    fun insert(user: User?)

    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)

    @get:Query("SELECT * FROM USER_TABLE")
    val allusers: LiveData<List<User>>
}