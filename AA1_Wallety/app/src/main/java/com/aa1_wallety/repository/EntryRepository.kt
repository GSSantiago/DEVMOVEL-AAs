package com.aa1_wallety.repository

import kotlinx.coroutines.flow.Flow

class EntryRepository(private val entryDao: EntryDao) {

    fun getAllEntriesStream(): Flow<List<Entry>> = entryDao.getAllEntries()

    suspend fun insertEntry(entry: Entry) = entryDao.insertEntry(entry)

}