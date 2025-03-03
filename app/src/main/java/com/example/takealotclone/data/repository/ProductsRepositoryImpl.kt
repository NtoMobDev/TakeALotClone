package com.example.takealotclone.data.repository

import com.example.takealotclone.data.remote.ApiService
import com.example.takealotclone.domain.model.Product
import com.example.takealotclone.domain.repository.ProductsRepository
import com.example.takealotclone.toProductDomainModel
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsApi:ApiService):ProductsRepository {
    override suspend fun getAllProducts(): List<Product> {
        return productsApi.getAllProducts().map { it.toProductDomainModel() }
    }
}