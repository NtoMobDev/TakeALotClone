package com.example.bestBuy.domain.model

import com.example.bestBuy.data.dto.CategoryDto


/*data class Product(
    val category: CategoryDto,
    val creationAt: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val slug: String,
    val title: String,
    val updatedAt: String
)*/
data class Product(
    val category: CategoryDto,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String,

)