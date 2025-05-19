package com.example.bestBuy.presentation.state

data class CategoryUiState(
    val isLoading: Boolean = false,
    val categories:List<String> = emptyList(),
    val error :String = ""
)
