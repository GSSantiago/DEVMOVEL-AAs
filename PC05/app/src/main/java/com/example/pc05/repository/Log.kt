package com.example.pc05.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ApiLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val offsetBuscado: Int,
    val timestamp: String
)