package com.aa1_wallety.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class AddEntryModalViewModel : ViewModel() {

    private val categoriesDespesa = listOf("Alimentação", "Saúde", "Transporte", "Lazer", "Outros")
    private val categoriesReceita = listOf("Salário", "Freelance", "Presente", "Reembolso", "Outros")

    var isExpense by mutableStateOf(true)
    var categories by mutableStateOf(categoriesDespesa)
    var category by mutableStateOf(categoriesDespesa[0])

    var expanded by mutableStateOf(false)
    var showDatePicker by mutableStateOf(false)
    var date by mutableStateOf("01/01/2026")

    var title by mutableStateOf("")
    var amount by mutableStateOf(NumberFormat.getCurrencyInstance().format(0.0))
    var description by mutableStateOf("")

    fun setTransactionType(expense: Boolean) {
        isExpense = expense
        if (expense) {
            categories = categoriesDespesa
            category = categoriesDespesa[0]
        } else {
            categories = categoriesReceita
            category = categoriesReceita[0]
        }
    }

    fun updateAmount(input: String) {
        val cleanString = input.replace(Regex("[^0-9]"), "")

        if (cleanString.isEmpty()) {
            amount = NumberFormat.getCurrencyInstance().format(0.0)
            return
        }

        val parsed = cleanString.toDouble() / 100
        amount = NumberFormat.getCurrencyInstance().format(parsed)
    }

    fun resetValues() {
        title = ""
        amount = NumberFormat.getCurrencyInstance().format(0.0)
        description = ""
        setTransactionType(true)
    }
}