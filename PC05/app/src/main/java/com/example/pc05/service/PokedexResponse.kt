package com.example.pc05.service
import com.google.gson.annotations.SerializedName

data class PokedexResponse(
    @SerializedName("results") val results: List<PokemonResult>
)

data class PokemonResult(
    @SerializedName("name") val name: String
)