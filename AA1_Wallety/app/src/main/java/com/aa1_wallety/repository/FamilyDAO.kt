package com.aa1_wallety.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FamilyDao {

    @Query("SELECT * FROM FamilyEntry ORDER BY id DESC")
    fun getAllFamilyEntries(): Flow<List<FamilyEntry>>

    @Insert
    suspend fun insertFamilyEntry(family: FamilyEntry)

    @Query("DELETE FROM FamilyEntry")
    suspend fun deleteAllFamilyEntries()
}