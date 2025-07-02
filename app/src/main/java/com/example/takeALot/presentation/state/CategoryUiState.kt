package com.example.takeALot.presentation.state

data class CategoryUiState(
    val isLoading: Boolean = false,
    val categories:List<String> = emptyList(),
    val error :String = ""
)
