package com.example.pokedex.data.retrofit.responses

import com.google.gson.annotations.SerializedName

data class Versions(
    @SerializedName("generation-i") val generationPrimera: GenerationI,
    @SerializedName("generation-ii") val generationSegunda: GenerationIi,
    @SerializedName("generation-iii") val generationTercera: GenerationIii,
    @SerializedName("generation-iv") val generationCuarta: GenerationIv,
    @SerializedName("generation-v") val generationQuinta: GenerationV,
    @SerializedName("generation-vi") val generationSexta: GenerationVi,
    @SerializedName("generation-vii") val generationSeptima: GenerationVii,
    @SerializedName("generation-viii") val generationOctaba: GenerationViii
)