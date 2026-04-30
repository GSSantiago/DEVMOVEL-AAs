package com.example.pc05

import android.app.Application
import android.content.Context
import com.example.pc05.repository.LogDatabase
import com.example.pc05.repository.PokedexRepository

class PokedexApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}

class AppContainer(private val context: Context) {
    val pokedexRepository : PokedexRepository by lazy {
        PokedexRepository(LogDatabase.getDatabase(context).logDao())
    }
}