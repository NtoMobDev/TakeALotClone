package com.example.bestBuy.data.repository

import com.example.bestBuy.common.toCategoryDomainModel
import com.example.bestBuy.data.remote.ApiService
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.domain.repository.ProductsRepository
import com.example.bestBuy.common.toProductDomainModel
import com.example.bestBuy.domain.model.Category
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsApi:ApiService):ProductsRepository {
    override suspend fun getAllProducts(): List<Product> {
        return productsApi.getAllProducts().map { it.toProductDomainModel() }
    }

    override suspend fun getAllCategories(): List<Category> {
        return productsApi.getAllCategories().map{it.toCategoryDomainModel()}
    }

}