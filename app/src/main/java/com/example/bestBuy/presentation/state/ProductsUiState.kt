package com.example.bestBuy.presentation.state

import com.example.bestBuy.domain.model.Product

data class ProductsUiState(
    val isLoading: Boolean = false,
    val products:List<Product> = emptyList(),
    val error :String = ""
)
