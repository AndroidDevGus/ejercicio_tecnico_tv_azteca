package com.example.ejercicio_tecnico_azteca.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ShowDto(
    val id: Int,
    val name: String,
    val status: String?,
    val premiered: String?,
    val rating: RatingDto?,
    val genres: List<String>,
    val image: ImageDto?,
    val summary: String?,
    val network: NetworkDto?,
    @SerializedName("webChannel")
    val webChannel: WebChannelDto?
)

data class RatingDto(val average: Double?)
data class ImageDto(val medium: String?, val original: String?)
data class NetworkDto(val name: String?)
data class WebChannelDto(val name: String?)
data class SearchResultDto(val score: Double, val show: ShowDto)