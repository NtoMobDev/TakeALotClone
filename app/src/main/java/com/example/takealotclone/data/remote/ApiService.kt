package com.example.takealotclone.data.remote

import com.example.takealotclone.data.dto.ProductsDto
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts():List<ProductsDto>
}