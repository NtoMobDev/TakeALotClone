package com.example.takeALot.presentation.state

import com.example.takeALot.domain.model.Product

data class HomePageUiState(
    val isLoading: Boolean = false,
    val products:List<Product> = emptyList(),
    val categories:List<String> = emptyList(),
    val error :String? = null
)
