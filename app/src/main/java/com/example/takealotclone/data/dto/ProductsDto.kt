package com.example.takealotclone.data.dto

import com.google.gson.annotations.SerializedName

data class ProductsDto(
    val availability: Boolean,
    val brand: String,
    val category: String,
    val description: String,
    val discount: Int,
    val image: String,
    val name: String,
    val price: Double,
    @SerializedName("id") val product_id: Int,
    val rating: Double,
    val reviews: List<Review>,
    val unit: String
)