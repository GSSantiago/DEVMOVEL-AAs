package com.aa1_wallety.service

import com.aa1_wallety.repository.FamilyEntry
import retrofit2.http.GET

interface FamilyInterface {

    @GET("Family")
    suspend fun getFamilyEntries() : List<FamilyEntry>
}