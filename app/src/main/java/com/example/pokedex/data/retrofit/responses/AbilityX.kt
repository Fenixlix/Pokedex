package com.example.pokedex.data.retrofit.responses

import com.google.gson.annotations.SerializedName

data class AbilityX(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)