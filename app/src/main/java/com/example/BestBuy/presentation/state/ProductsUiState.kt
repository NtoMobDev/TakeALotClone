package com.example.BestBuy.presentation.state

import com.example.BestBuy.domain.model.Product

data class ProductsUiState(
    val isLoading: Boolean = false,
    val products:List<Product> = emptyList(),
    val error :String = ""
)
