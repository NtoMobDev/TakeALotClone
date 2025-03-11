package com.example.BestBuy.common

import com.example.BestBuy.data.dto.CategoryDto
import com.example.BestBuy.data.dto.ProductsDto
import com.example.BestBuy.domain.model.Category
import com.example.BestBuy.domain.model.Product

fun ProductsDto.toProductDomainModel() : Product {
    return Product(category = this.category,
    description = this.description,
    id = this.id,
    images = this.images,
    price = this.price,
    title = this.title)
}

fun CategoryDto.toCategoryDomainModel() : Category {
    return Category(
    id = this.id,
    image = this.image,
    name = this.name

    )
}



/*fun List<ProductsDto>.toDomain(): List<Product> = map {
    Product(category =it.category,
        description = it.description,
        id = it.id,
        images = it.images,
        price = it.price,
        title = it.title)
}*/
