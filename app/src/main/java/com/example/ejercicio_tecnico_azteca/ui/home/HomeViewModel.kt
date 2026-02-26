package com.example.ejercicio_tecnico_azteca.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicio_tecnico_azteca.domain.usecase.BuildShowSectionsUseCase
import com.example.ejercicio_tecnico_azteca.domain.usecase.GetShowsUseCase
import com.example.ejercicio_tecnico_azteca.domain.usecase.SearchShowsUseCase
import com.example.ejercicio_tecnico_azteca.domain.usecase.ShowSection
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.onFailure

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getShowsUseCase: GetShowsUseCase,
    private val searchShowsUseCase: SearchShowsUseCase,
    private val buildShowSectionsUseCase: BuildShowSectionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init { loadShows() }

    fun loadShows() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            getShowsUseCase()
                .onSuccess { shows ->
                    _uiState.value = HomeUiState.Success(
                        sections = buildShowSectionsUseCase(shows)
                    )
                }
                .onFailure { error ->
                    _uiState.value = HomeUiState.Error(
                        error.message ?: "Error al cargar"
                    )
                }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) { loadShows(); return }

        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            searchShowsUseCase(query)
                .onSuccess { shows ->
                    _uiState.value = HomeUiState.Success(
                        sections = listOf(ShowSection("Resultados", shows))
                    )
                }
                .onFailure { error ->
                    _uiState.value = HomeUiState.Error(
                        error.message ?: "Error en búsqueda"
                    )
                }
        }
    }
}