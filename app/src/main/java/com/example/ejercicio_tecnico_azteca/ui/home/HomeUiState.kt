package com.example.ejercicio_tecnico_azteca.ui.home

import com.example.ejercicio_tecnico_azteca.domain.usecase.ShowSection

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(val sections: List<ShowSection>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}