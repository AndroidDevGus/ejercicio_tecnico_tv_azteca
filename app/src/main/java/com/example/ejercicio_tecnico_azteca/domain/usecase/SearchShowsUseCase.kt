package com.example.ejercicio_tecnico_azteca.domain.usecase

import com.example.ejercicio_tecnico_azteca.domain.model.Show
import com.example.ejercicio_tecnico_azteca.domain.repository.ShowRepository
import jakarta.inject.Inject

class SearchShowsUseCase @Inject constructor(
    private val repository: ShowRepository
) {
    suspend operator fun invoke(query: String): Result<List<Show>> {
        if (query.isBlank()) return Result.failure(IllegalArgumentException("Query vacío"))
        return repository.searchShows(query)
    }
}