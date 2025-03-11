package com.example.BestBuy.domain.repository

import com.example.BestBuy.domain.model.Product

interface ProductsRepository {

    suspend fun getAllProducts() : List<Product>


}