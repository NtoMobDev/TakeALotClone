package com.example.bestBuy.data.remote

import com.example.bestBuy.data.dto.CategoryDto
import com.example.bestBuy.data.dto.ProductsDto
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): List<ProductsDto>

    @GET("categories")
    suspend fun getAllCategories():List<CategoryDto>


}