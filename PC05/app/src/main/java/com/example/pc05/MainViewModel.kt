package com.example.pc05

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pc05.repository.PokedexRepository
import com.example.pc05.service.PokemonResult
import kotlinx.coroutines.launch

class MainViewModel(private val pokedexRepository: PokedexRepository)  : ViewModel() {

    var offset by mutableStateOf(0)

    var pokemonList by mutableStateOf<List<PokemonResult>>(emptyList())

    init {
        buscarPokemons(0)
    }

    fun buscarPokemons(novoOffset: Int) {
        viewModelScope.launch {
            try {
                val response = pokedexRepository.getPokemonList(novoOffset, 20)

                pokemonList = response.results
                offset = novoOffset

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}