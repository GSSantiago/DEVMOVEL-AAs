package com.aa1_wallety.repository

import com.aa1_wallety.service.EntryInterface
import com.aa1_wallety.service.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class EntryRepository(private val entryDao: EntryDao) {

    private var client: EntryInterface

    init {
        client = RetrofitInstance.api
    }

    fun getAllEntries(): Flow<List<Entry>> = entryDao.getAllEntries()

    suspend fun insertEntry(entry: Entry) {
        entryDao.insertEntry(entry)

        try {
            client.addEntry(entry)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun refreshEntriesFromApi() {
        try {
            val apiEntries = client.getEntries()

            entryDao.deleteAllEntries()

            apiEntries.forEach { apiEntry ->
                entryDao.insertEntry(apiEntry)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}