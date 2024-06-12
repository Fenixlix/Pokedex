package com.example.pokedex.detail_screen.model

import com.example.pokedex.data.retrofit.responses.Ability
import com.example.pokedex.data.retrofit.responses.Move
import com.example.pokedex.data.retrofit.responses.Sprites
import com.example.pokedex.data.retrofit.responses.Type

data class PokemonDetails(
    val name: String,
    val id: Int,
    val sprites: Sprites,
    val height: Int,
    val weight: Int,
    val abilities: List<Ability>,
    val types: List<Type>,
    val moves: List<Move>
)