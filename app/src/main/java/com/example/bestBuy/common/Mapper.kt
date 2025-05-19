package com.example.bestBuy.common

import com.example.bestBuy.data.dto.CategoryDto
import com.example.bestBuy.data.dto.ProductDto
import com.example.bestBuy.data.dto.ResponseDto
import com.example.bestBuy.domain.model.Category
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.domain.model.Response

fun ResponseDto.toResponseDomainModel() : Response {
        return Response(
            message = this.message,
            products = this.products.map { it.toProductDomainModel() },  // Mapping ProductDto list to Product list
            status = this.status
        )

}

fun ProductDto.toProductDomainModel(): Product {
    return Product(brand = this.brand,
    category = this.category,
    color = this.color,
    description = this.description,
    discount = this.discount,
    id = this.id,
    image = this.image,
    model = this.model,
    onSale = this.onSale,
    popular = this.popular,
    price = this.price,
    title = this.title
    )
}

fun CategoryDto.toCategoryDomainModel() : Category {
    return Category(
        categories = this.categories,
        message = this.message,
        status = this.status)
}


/*fun List<ProductsDto>.toDomain(): List<Product> = map {
    Product(category =it.category,
        description = it.description,
        id = it.id,
        images = it.images,
        price = it.price,
        title = it.title)
}*/
