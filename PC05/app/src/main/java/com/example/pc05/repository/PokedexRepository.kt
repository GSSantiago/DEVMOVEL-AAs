package com.example.pc05.repository

import com.example.pc05.service.PokedexResponse
import com.example.pc05.service.RetrofitInstance
import java.util.Date

class PokedexRepository(private val logDao: LogDao){
    private val api = RetrofitInstance.api

    suspend fun getPokemonList(offset: Int, limit: Int) : PokedexResponse {
       val log = ApiLog(offsetBuscado = offset, timestamp = Date().toString())
        logDao.insert(log)

        return api.getPokemons(offset, limit)
    }
}