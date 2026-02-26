package com.example.ejercicio_tecnico_azteca.domain.usecase

import com.example.ejercicio_tecnico_azteca.domain.model.Show
import com.example.ejercicio_tecnico_azteca.domain.repository.ShowRepository
import jakarta.inject.Inject

class GetShowsUseCase @Inject constructor(
    private val repository: ShowRepository
) {
    suspend operator fun invoke(page: Int = 0): Result<List<Show>> =
        repository.getShows(page)
}