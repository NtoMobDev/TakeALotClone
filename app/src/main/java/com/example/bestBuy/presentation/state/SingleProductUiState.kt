package com.example.bestBuy.presentation.state

import com.example.bestBuy.domain.model.Product

data class SingleProductUiState(
    val isLoading:Boolean = false,
    val product: Product? = null,
    val error :String? = null
)