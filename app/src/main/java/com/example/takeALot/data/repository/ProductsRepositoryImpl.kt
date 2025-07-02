package com.example.takeALot.data.repository


import com.example.takeALot.data.remote.ApiService
import com.example.takeALot.domain.repository.ProductsRepository
import com.example.takeALot.common.toProductDomainModel

import com.example.takeALot.domain.model.Product
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

    override suspend fun getProductsByCategory(category: String): List<Product> {
        return productsApi.getProductsByCategory(category).products.map { it.toProductDomainModel() }
    }



}