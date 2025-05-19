package com.example.bestBuy.data.dto

data class ResponseDto(
    val message: String,
    val products: List<ProductDto>,
    val status: String
)