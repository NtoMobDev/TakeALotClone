package com.example.takealotclone.domain

import com.example.takealotclone.common.UiState
import com.example.takealotclone.data.repository.ProductsRepositoryImpl
import com.example.takealotclone.domain.model.Product
import com.example.takealotclone.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val productsRepo: ProductsRepositoryImpl){
    operator fun invoke(): Flow<UiState<List<Product>>> = flow {

            emit(UiState.Loading())
            try {
                emit(UiState.Success(data = productsRepo.getAllProducts()))
            }catch (e : Exception){
                emit(UiState.Error(message = e.message.toString()))
            }
        }.flowOn(Dispatchers.IO) //// Ensure the network request runs on IO dispatcher


}