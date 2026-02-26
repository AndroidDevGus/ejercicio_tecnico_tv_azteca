package com.example.ejercicio_tecnico_azteca.domain.usecase

import com.example.ejercicio_tecnico_azteca.domain.model.Show
import jakarta.inject.Inject

class BuildShowSectionsUseCase @Inject constructor() {
    operator fun invoke(shows: List<Show>): List<ShowSection> {
        val topRated = shows
            .filter { (it.rating ?: 0.0) >= 7.0 }
            .sortedByDescending { it.rating }
        val running = shows.filter { it.status == "Running" }
        val ended   = shows.filter { it.status == "Ended" }

        return buildList {
            if (topRated.isNotEmpty()) add(ShowSection("⭐ Mejor valoradas", topRated))
            if (running.isNotEmpty())  add(ShowSection("📺 En emisión", running))
            if (ended.isNotEmpty())    add(ShowSection("🎬 Finalizadas", ended))
        }
    }
}

data class ShowSection(
    val title: String,
    val shows: List<Show>
)