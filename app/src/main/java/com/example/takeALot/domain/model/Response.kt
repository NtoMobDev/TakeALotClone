package com.example.takeALot.domain.model

data class Response(
    val message: String,
    val products: List<Product>,
    val status: String
)