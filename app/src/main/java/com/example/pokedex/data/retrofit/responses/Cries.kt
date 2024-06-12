package com.example.pokedex.data.retrofit.responses

import com.google.gson.annotations.SerializedName

data class Cries(
    @SerializedName("latest") val latest: String,
    @SerializedName("legacy") val legacy: String
)