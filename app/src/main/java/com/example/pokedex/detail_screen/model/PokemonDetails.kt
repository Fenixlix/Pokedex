package com.example.pokedex.detail_screen.model

import com.example.pokedex.data.retrofit.responses.Ability
import com.example.pokedex.data.retrofit.responses.Move
import com.example.pokedex.data.retrofit.responses.Sprites
import com.example.pokedex.data.retrofit.responses.Type

data class PokemonDetails(
    val name: String,
    val id: Int,
    val types: List<Type>,
    val height: Int,
    val weight: Int,
    val sprites: Sprites,
    val abilities: List<Ability>,
    val moves: List<Move>
)

fun PokemonDetails.getTypeList(): List<PkTypeList> {
    val typeList = mutableListOf<PkTypeList>()
    this.types.forEach { pkType ->
        typeList.add(PkTypeList.getType(pkType.type.name))
    }
    return typeList
}