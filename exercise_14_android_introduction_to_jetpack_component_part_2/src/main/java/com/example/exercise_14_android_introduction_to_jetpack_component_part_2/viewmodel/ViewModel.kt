package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.database.UserRepository
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.model.User

/**
 * ViewModel class
 */
class ViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository = UserRepository(application)


    val allUsers: LiveData<List<User>>

    /**
     * Insert user
     */
    fun insert(user: User?) {
        repository.insert(user)
    }

    /**
     * update user
     */
    fun update(user: User?) {
        repository.update(user)
    }

    /**
     * delete user
     */
    fun delete(user: User?) {
        repository.delete(user)
    }

    /**
     * return allUsers from repo
     */
    init {
        allUsers = repository.allUsers
    }
}