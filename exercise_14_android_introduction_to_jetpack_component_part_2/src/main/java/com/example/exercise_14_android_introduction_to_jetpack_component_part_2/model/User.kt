package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Model class
 */
@Entity(tableName = "user_table")
class User(
    @field:ColumnInfo(name = "user_name")
    val name: String,
    @field:ColumnInfo(name = "user_email")
    val email: String,
    @field:ColumnInfo(name = "user_phone")
    val phone: String,
    @field:ColumnInfo(name = "user_address")
    val address: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}