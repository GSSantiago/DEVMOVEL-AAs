package com.aa1_wallety.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EntryDao {

    @Query("SELECT * FROM Entry ORDER BY id DESC")
    fun getAllEntries(): Flow<List<Entry>>

    @Insert
    suspend fun insertEntry(entry: Entry)
}