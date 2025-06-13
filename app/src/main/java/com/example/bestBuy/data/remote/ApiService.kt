package com.example.bestBuy.data.remote

import com.example.bestBuy.data.dto.CategoryDto
import com.example.bestBuy.data.dto.ResponseDto
import com.example.bestBuy.data.dto.SingleProductDto
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("products/{id}")
    suspend fun getSingleProduct(@Path("id") id:Int):SingleProductDto


    @GET("products/category")
    suspend fun getProductsByCategory(@Query("type") type: String): ResponseDto


}