package com.aa1_wallety.repository

import com.aa1_wallety.service.FamilyInterface
import com.aa1_wallety.service.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class FamilyRepository(private val familyDao: FamilyDao) {

    private var client: FamilyInterface

    init {
        client = RetrofitInstance.familyApi
    }

    fun getAllEntries(): Flow<List<FamilyEntry>> = familyDao.getAllFamilyEntries()


    suspend fun refreshEntriesFromApi() {
        try {
            val apiEntries = client.getFamilyEntries()

            familyDao.deleteAllFamilyEntries()

            for (apiEntry in apiEntries) {
                familyDao.insertFamilyEntry(apiEntry)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}