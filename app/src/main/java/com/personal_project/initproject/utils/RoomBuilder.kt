package com.personal_project.initproject.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.personal_project.initproject.data.dao.UserDao
import com.personal_project.initproject.data.entity.User

@Database(entities = [User::class], version = 1)
abstract class RoomBuilder : RoomDatabase(){
    abstract fun userDao() : UserDao

    companion object {
        private var instance: RoomBuilder? = null

        @Synchronized
        fun getInstance(context: Context): RoomBuilder? {
            if (instance == null) {
                synchronized(RoomBuilder::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomBuilder::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }
}