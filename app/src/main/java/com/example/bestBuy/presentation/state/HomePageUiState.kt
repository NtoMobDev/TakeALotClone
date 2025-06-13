package com.example.bestBuy.presentation.state

import com.example.bestBuy.domain.model.Product

data class HomePageUiState(
    val isLoading: Boolean = false,
    val products:List<Product> = emptyList(),
    val categories:List<String> = emptyList(),
    val error :String? = null
)
