package com.example.ejercicio_tecnico_azteca.data.remote

import com.example.ejercicio_tecnico_azteca.data.remote.dto.SearchResultDto
import com.example.ejercicio_tecnico_azteca.data.remote.dto.ShowDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("shows")
    suspend fun getShows(@Query("page") page: Int = 0): List<ShowDto>

    @GET("search/shows")
    suspend fun searchShows(@Query("q") query: String): List<SearchResultDto>
}