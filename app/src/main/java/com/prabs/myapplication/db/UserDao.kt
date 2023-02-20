package com.prabs.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAllUsers(): List<String>

    @Query("DELETE FROM UserEntity")
    fun deleteAllUsers()

    @Insert
    fun insert(user: String)
}