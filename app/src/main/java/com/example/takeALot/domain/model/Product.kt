package com.example.takeALot.domain.model

data class Product(
    val brand: String,
    val category: String,
    val color: String?,
    val description: String,
    val discount: Int,
    val id: Int,
    val image: String,
    val model: String,
    val onSale: Boolean,
    val popular: Boolean,
    val price: Int,
    val title: String,

)