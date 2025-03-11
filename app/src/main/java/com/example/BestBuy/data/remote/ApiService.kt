package com.example.BestBuy.data.remote

import com.example.BestBuy.data.dto.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): List<ProductsDto>


}