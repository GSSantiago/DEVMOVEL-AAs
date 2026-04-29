package com.example.pc05.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ApiLog::class], version = 1, exportSchema = false)
abstract class LogDatabase : RoomDatabase() {
    abstract fun logDao(): LogDao

    companion object {
        @Volatile
        private var Instance: LogDatabase? = null

        fun getDatabase(context: Context): LogDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, LogDatabase::class.java, "log_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}