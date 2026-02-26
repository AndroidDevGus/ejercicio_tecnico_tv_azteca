package com.example.ejercicio_tecnico_azteca.data.remote.mapper

import com.example.ejercicio_tecnico_azteca.data.remote.dto.ShowDto
import com.example.ejercicio_tecnico_azteca.domain.model.Show

object ShowMapper {
    fun ShowDto.toDomain() = Show(
        id = id,
        name = name,
        status = status ?: "Unknown",
        premiered = premiered ?: "N/A",
        rating = rating?.average,
        genres = genres,
        imageUrl = image?.medium,
        summary = summary
            ?.replace(Regex("<[^>]*>"), "")
            ?: "Sin descripción",
        network = network?.name ?: webChannel?.name ?: "Unknown"
    )
}