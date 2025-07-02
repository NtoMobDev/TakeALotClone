package com.example.takeALot.domain.repository


import com.example.takeALot.domain.model.Product

interface ProductsRepository {

    suspend fun getAllProducts() : List<Product>

    suspend fun getAllCategories(): List<String>

    suspend fun getHomePageProductList(limit:Int) : List<Product>

    suspend fun getSingleProduct(id:Int):Product

    suspend fun getProductsByCategory(category:String):List<Product>



}