package com.example.bestBuy.presentation.state

import com.example.bestBuy.domain.model.Category

data class CategoryUiState(
    val isLoading: Boolean = false,
    val categories:List<Category> = emptyList(),
    val error :String = ""
)
