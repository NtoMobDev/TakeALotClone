package com.example.takealotclone.common

import com.example.takealotclone.data.dto.ProductsDto
import com.example.takealotclone.domain.model.Product

fun ProductsDto.toProductDomainModel() : Product {
    return Product(name = this.name,image = this.image,price = this.price,
        description = this.description)
}
