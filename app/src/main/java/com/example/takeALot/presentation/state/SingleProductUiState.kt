package com.example.takeALot.presentation.state

import com.example.takeALot.domain.model.Product

data class SingleProductUiState(
    val isLoading:Boolean = false,
    val product: Product? = null,
    val error :String? = null
)

data class SingleProductPageUiState(
    val isLoading: Boolean = false,
    val product: Product? = null,
    val relatedProducts: List<Product> = emptyList(),
    val error: String? = null

)