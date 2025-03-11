package com.example.BestBuy.data.repository

import com.example.BestBuy.data.remote.ApiService
import com.example.BestBuy.domain.model.Product
import com.example.BestBuy.domain.repository.ProductsRepository
import com.example.BestBuy.common.toProductDomainModel
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsApi:ApiService):ProductsRepository {
    override suspend fun getAllProducts(): List<Product> {
        return productsApi.getAllProducts().map { it.toProductDomainModel() }
    }

}