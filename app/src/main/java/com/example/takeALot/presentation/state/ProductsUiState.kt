package com.example.takeALot.presentation.state

import com.example.takeALot.domain.model.Product

data class ProductsUiState(
    val isLoading: Boolean = false,
    val products:List<Product> = emptyList(),
    val error :String? = null
)
