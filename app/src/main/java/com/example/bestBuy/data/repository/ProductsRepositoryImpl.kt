package com.example.bestBuy.data.repository


import com.example.bestBuy.data.remote.ApiService
import com.example.bestBuy.domain.repository.ProductsRepository
import com.example.bestBuy.common.toProductDomainModel

import com.example.bestBuy.domain.model.Product
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsApi:ApiService):ProductsRepository {
    override suspend fun getAllProducts(): List<Product> {
        return productsApi.getAllProducts().products.map { it.toProductDomainModel() }
    }

    override suspend fun getAllCategories(): List<String> {
        return productsApi.getAllCategories().categories
    }

    override suspend fun getHomePageProductList(limit: Int): List<Product> {
        return productsApi.getLimitedProducts(limit).products.map { it.toProductDomainModel() }

    }

    override suspend fun getSingleProduct(id: Int): Product {
        return productsApi.getSingleProduct(id).product.toProductDomainModel()
    }

}