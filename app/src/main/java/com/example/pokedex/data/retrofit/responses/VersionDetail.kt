package com.example.pokedex.data.retrofit.responses

import com.google.gson.annotations.SerializedName

data class VersionDetail(
    @SerializedName("rarity") val rarity: Int,
    @SerializedName("version") val version: Version
)