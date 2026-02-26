package com.example.ejercicio_tecnico_azteca.data.repository

import com.example.ejercicio_tecnico_azteca.data.remote.ApiService
import com.example.ejercicio_tecnico_azteca.data.remote.mapper.ShowMapper
import com.example.ejercicio_tecnico_azteca.domain.model.Show
import com.example.ejercicio_tecnico_azteca.domain.repository.ShowRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ShowRepositoryImpl @Inject constructor(  // ← ¿tienes @Inject constructor?
    private val apiService: ApiService
) : ShowRepository {

    override suspend fun getShows(page: Int): Result<List<Show>> =
        runCatching {
            apiService.getShows(page).map {
                with(ShowMapper) { it.toDomain() }
            }
        }

    override suspend fun searchShows(query: String): Result<List<Show>> =
        runCatching {
            apiService.searchShows(query).map {
                with(ShowMapper) { it.show.toDomain() }
            }
        }
}