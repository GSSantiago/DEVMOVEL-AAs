package com.aa1_wallety

import com.aa1_wallety.compose.LoginViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginViewModelTest {

    @Test
    fun formulario_fica_valido() {
        val viewModel = LoginViewModel()

        viewModel.email = "professor@teste.com"
        viewModel.password = "123456"


        assertEquals(true, viewModel.isFormValid)
    }
}