package com.example.pokedex.data.retrofit.responses

import com.google.gson.annotations.SerializedName

data class TypeX(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)