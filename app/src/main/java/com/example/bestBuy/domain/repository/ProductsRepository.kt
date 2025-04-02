package com.example.bestBuy.domain.repository


import com.example.bestBuy.domain.model.Product

interface ProductsRepository {

    suspend fun getAllProducts() : List<Product>

    suspend fun getAllCategories(): List<String>


}