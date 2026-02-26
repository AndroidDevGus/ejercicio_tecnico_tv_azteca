package com.example.ejercicio_tecnico_azteca.domain.model

data class Show(
    val id: Int,
    val name: String,
    val status: String,
    val premiered: String,
    val rating: Double?,
    val genres: List<String>,
    val imageUrl: String?,
    val summary: String,
    val network: String
)