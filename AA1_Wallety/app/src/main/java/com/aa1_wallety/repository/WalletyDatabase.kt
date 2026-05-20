package com.aa1_wallety.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entry::class, FamilyEntry::class], version = 2, exportSchema = false)
abstract class WalletyDatabase : RoomDatabase() {
    abstract fun entryDao(): EntryDao
    abstract fun familyDao(): FamilyDao

    companion object {
        @Volatile
        private var Instance: WalletyDatabase? = null

        fun getDatabase(context: Context): WalletyDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, WalletyDatabase::class.java, "wallety_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}