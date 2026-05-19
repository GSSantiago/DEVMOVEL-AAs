package com.aa1_wallety.service

import com.aa1_wallety.repository.Entry
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EntryInterface {

    @GET("Entry")
    suspend fun getEntries() : List<Entry>

    @POST("Entry")
    suspend fun addEntry(@Body entry: Entry): Entry
}