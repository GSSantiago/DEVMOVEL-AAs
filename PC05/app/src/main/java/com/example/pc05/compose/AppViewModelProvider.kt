package com.example.pc05.compose

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pc05.MainViewModel
import com.example.pc05.PokedexApplication


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            MainViewModel(pokedexApplication().container.pokedexRepository)
        }
    }
}

fun CreationExtras.pokedexApplication(): PokedexApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)