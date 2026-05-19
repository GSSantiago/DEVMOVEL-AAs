package com.aa1_wallety

import android.app.Application
import android.content.Context
import android.util.Log
import com.aa1_wallety.repository.WalletyDatabase
import com.aa1_wallety.repository.EntryRepository

class WalletyApplication : Application() {
lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
        Log.i("WalletyApplication", "onCreate")
    }
}

class AppContainer(private val context: Context) {
    val repository : EntryRepository by lazy {
        EntryRepository(WalletyDatabase.getDatabase(context).entryDao())
    }
}