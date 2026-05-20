package com.aa1_wallety.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    val isFormValid: Boolean
        get() = email.isNotBlank() && password.isNotBlank()

    fun clearFields() {
        email = ""
        password = ""
    }
}