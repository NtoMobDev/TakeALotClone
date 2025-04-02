package com.example.bestBuy.data.remote

import com.example.bestBuy.data.dto.CategoryDto
import com.example.bestBuy.data.dto.ResponseDto
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): ResponseDto

    @GET("products/category")
    suspend fun getAllCategories():CategoryDto


}