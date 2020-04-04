package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.model.User
import org.jetbrains.anko.doAsync

internal class UserRepository(application: Application?) {
    private val userDao: UserDao

    /**
     * Return all user
     */
    val allUsers: LiveData<List<User>>

    /**
     * Insert user
     */
    fun insert(user: User?) {
        doAsync {
            userDao.insert(user)
        }
    }

    /**
     * Update user
     */
    fun update(user: User?) {
        doAsync {
            userDao.update(user)
        }
    }

    /**
     * delete user
     */
    fun delete(user: User?) {
        doAsync {
            userDao.delete(user)
        }
    }

    init {
        val database = UserDatabase.getInstance(application!!.applicationContext)
        userDao = database!!.userDao()
        allUsers = userDao.allusers
    }
}