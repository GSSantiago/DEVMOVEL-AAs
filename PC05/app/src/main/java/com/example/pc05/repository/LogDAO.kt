package com.example.pc05.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {
    @Insert
    suspend fun insert(log: ApiLog)

    @Query("SELECT * FROM ApiLog")
    fun getAllLogs(): Flow<List<ApiLog>>
}