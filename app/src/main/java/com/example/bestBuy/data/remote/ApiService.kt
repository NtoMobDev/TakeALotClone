package com.example.bestBuy.data.remote

import com.example.bestBuy.data.dto.CategoryDto
import com.example.bestBuy.data.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): ResponseDto

    @GET("products/category")
    suspend fun getAllCategories():CategoryDto

    @GET("products")
    suspend fun getLimitedProducts(
        @Query("limit") limit: Int // Query parameter for limiting results
    ): ResponseDto


}