package com.aa1_wallety.compose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FinancialEntry(
    val id: Int,
    val title: String,
    val amount: Double,
    val type: String,
    val category: String,
    val date: String
)

class WalletyViewModel : ViewModel() {
    private val _entries = MutableStateFlow(
        listOf(
            FinancialEntry(1, "Reeeeeee", 2813.41, "Despesa", "Alimentação", "07/04/2026"),
            FinancialEntry(2, "Reembolso Plano de Saúde", 250.41, "Receita", "Reembolso", "07/04/2026"),
            FinancialEntry(3, "Cinema Mario Galaxy", 120.00, "Despesa", "Entretenimento", "21/03/2026")
        )
    )
    val entries: StateFlow<List<FinancialEntry>> = _entries.asStateFlow()
}