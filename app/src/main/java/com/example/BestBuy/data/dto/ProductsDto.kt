package com.example.BestBuy.data.dto

data class ProductsDto(
    val category: CategoryDto,
    val creationAt: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val slug: String,
    val title: String,
    val updatedAt: String
)