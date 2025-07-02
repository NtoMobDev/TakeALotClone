package com.example.takeALot.data.dto

data class ResponseDto(
    val message: String,
    val products: List<ProductDto>,
    val status: String
)