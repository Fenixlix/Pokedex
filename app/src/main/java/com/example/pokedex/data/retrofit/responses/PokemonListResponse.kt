package com.example.pokedex.data.retrofit.responses

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val results: List<Result>
)