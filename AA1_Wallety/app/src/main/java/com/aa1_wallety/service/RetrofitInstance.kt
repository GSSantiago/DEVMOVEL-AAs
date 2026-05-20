package com.aa1_wallety.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://6a0a2af721e445625695dc8f.mockapi.io/wallety/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val entryApi: EntryInterface by lazy {
        retrofit.create(EntryInterface::class.java)
    }

    val familyApi: FamilyInterface by lazy {
        retrofit.create(FamilyInterface::class.java)
    }
}