package com.aa1_wallety.compose

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.aa1_wallety.WalletyApplication

/**
 * Provides Factory to create instance of ViewModel for the entire Wallety app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            WalletyViewModel(walletyApplication().container.repository)
        }


    }
}

fun CreationExtras.walletyApplication(): WalletyApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as WalletyApplication)