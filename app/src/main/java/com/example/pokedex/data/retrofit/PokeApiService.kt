package com.example.pokedex.data.retrofit

import com.example.pokedex.data.retrofit.responses.PokemonListResponse
import com.example.pokedex.data.retrofit.responses.SinglePokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    // https://pokeapi.co/api/v2/pokemon?offset=0&limit=40
    @GET("pokemon")
    suspend fun getPkList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonListResponse

    // https://pokeapi.co/api/v2/pokemon/{id}
    // https://pokeapi.co/api/v2/pokemon/{name}
    @GET("pokemon/{name_or_id}")
    suspend fun getSinglePokemon(
        @Path("name_or_id") nameOrId: String
    ): SinglePokemonResponse
}
