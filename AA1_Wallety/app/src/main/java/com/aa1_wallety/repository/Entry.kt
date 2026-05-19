package com.aa1_wallety.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val amount: Double,
    val isExpense: Boolean,
    val category: String,
    val date: String,
    val description: String
)