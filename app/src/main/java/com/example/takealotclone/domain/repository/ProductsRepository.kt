package com.example.takealotclone.domain.repository

import com.example.takealotclone.domain.model.Product

interface ProductsRepository {

    suspend fun getAllProducts() : List<Product>
}