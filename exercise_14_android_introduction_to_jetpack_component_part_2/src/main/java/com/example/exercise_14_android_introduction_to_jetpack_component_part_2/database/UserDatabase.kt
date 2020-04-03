package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.model.User
import org.jetbrains.anko.doAsync

/**
 * Room Database abstract class
 */
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        /**
         * setting up room - database
         */

        private var instance: UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context,
                        UserDatabase::class.java, "User_database"
                    )
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            }
            return instance
        }

        /**
         * Callback to populate random data
         */
        private val roomCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val userDao: UserDao = instance!!.userDao()
                doAsync {
                    userDao.insert(
                        User(
                            "Kartik",
                            "kartik@gmail.com",
                            "1234567890",
                            "Delhi"
                        )
                    )
                    userDao.insert(
                        User(
                            "Romi",
                            "Romi@gmail.com",
                            "2341573456",
                            "Up"
                        )
                    )
                    userDao.insert(
                        User(
                            "Rishab",
                            "Rishab@gmail.com",
                            "2346464748",
                            "Delhi"
                        )
                    )
                    userDao.insert(
                        User(
                            "Rani",
                            "Rani@gmail.com",
                            "0238483823",
                            "Chennai"
                        )
                    )
                    userDao.insert(
                        User(
                            "Shree",
                            "Shree@gmail.com",
                            "2224546743",
                            "Assam"
                        )
                    )
                    userDao.insert(
                        User(
                            "Rohan",
                            "Rohan@gmail.com",
                            "2346356753",
                            "Bihar"
                        )
                    )
                }
            }
        }
    }
}