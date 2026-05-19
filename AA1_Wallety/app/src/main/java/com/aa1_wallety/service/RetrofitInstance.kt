package com.aa1_wallety.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private
    //
    const val BASE_URL = "https://6a0a2af721e445625695dc8f.mockapi.io/wallety/"

    val api: EntryInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(EntryInterface::class.java)
    }
}