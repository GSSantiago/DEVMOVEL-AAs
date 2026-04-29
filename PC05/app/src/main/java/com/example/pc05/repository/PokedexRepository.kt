package com.example.pc05.repository

import com.example.pc05.service.PokedexResponse
import com.example.pc05.service.RetrofitInstance

class PokedexRepository {
    private val api = RetrofitInstance.api

    suspend fun getPokemonList(offset: Int, limit: Int) : PokedexResponse {
        return api.getPokemons(offset, limit)
    }
}