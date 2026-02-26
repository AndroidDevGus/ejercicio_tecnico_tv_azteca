package com.example.ejercicio_tecnico_azteca.domain.repository

import com.example.ejercicio_tecnico_azteca.domain.model.Show

interface ShowRepository {
    suspend fun getShows(page: Int = 0): Result<List<Show>>
    suspend fun searchShows(query: String): Result<List<Show>>
}