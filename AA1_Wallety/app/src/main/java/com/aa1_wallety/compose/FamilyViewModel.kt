package com.aa1_wallety.compose

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aa1_wallety.repository.FamilyEntry
import com.aa1_wallety.repository.FamilyRepository
import kotlinx.coroutines.launch
import java.text.NumberFormat

class FamilyViewModel(private val repository: FamilyRepository) : ViewModel() {

    var entries = mutableStateListOf<FamilyEntry>()

    val totalBalanceFormated: String
        get() {
            val income = entries.filter { !it.isExpense }.sumOf { it.amount }
            val expense = entries.filter { it.isExpense }.sumOf { it.amount }
            return NumberFormat.getCurrencyInstance().format(income - expense)
        }

    val familyIncomeFormated: String
        get() = NumberFormat.getCurrencyInstance().format(
            entries.filter { !it.isExpense }.sumOf { it.amount }
        )

    val familyExpenseFormated: String
        get() = NumberFormat.getCurrencyInstance().format(
            entries.filter { it.isExpense }.sumOf { it.amount }
        )

    val myIncomeFormated: String
        get() = NumberFormat.getCurrencyInstance().format(
            entries.takeLast(3).filter { !it.isExpense }.sumOf { it.amount }
        )

    val myExpenseFormated: String
        get() = NumberFormat.getCurrencyInstance().format(
            entries.takeLast(3).filter { it.isExpense }.sumOf { it.amount }
        )
    init {
        syncWithApi()
        loadEntries()
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
}