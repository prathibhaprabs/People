package com.prabs.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var sInstance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (sInstance == null) {
                sInstance = databaseBuilder(
                    context,
                    AppDatabase::class.java, "users"
                ).build()
            }
            return sInstance
        }
    }
}