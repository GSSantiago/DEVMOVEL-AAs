package com.aa1_wallety.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aa1_wallety.repository.Entry
import com.aa1_wallety.repository.EntryRepository
import kotlinx.coroutines.launch

class WalletyViewModel(private val repository: EntryRepository) : ViewModel() {

    var entries = mutableStateListOf<Entry>()

    var showAddEntryDialog by mutableStateOf(false)

    init {
        loadEntries()
        syncWithApi()
    }

    private fun syncWithApi() {
        viewModelScope.launch {
            repository.refreshEntriesFromApi()
        }
    }

    private fun loadEntries() {
        viewModelScope.launch {
            repository.getAllEntries().collect { dbEntries ->
                entries.clear()
                entries.addAll(dbEntries)
            }
        }
    }

    fun openDialog() {
        showAddEntryDialog = true
    }

    fun closeDialog() {
        showAddEntryDialog = false
    }

    fun addEntry(title: String, amount: Double, isExpense: Boolean, category: String, date: String, description: String) {
        val newEntry = Entry(
            title = title,
            amount = amount,
            isExpense = isExpense,
            category = category,
            date = date,
            description = description
        )

        viewModelScope.launch {
            repository.insertEntry(newEntry)
        }
    }
}