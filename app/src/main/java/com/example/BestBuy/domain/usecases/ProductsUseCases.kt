package com.example.BestBuy.domain.usecases

import com.example.BestBuy.common.Resource
import com.example.BestBuy.domain.model.Product
import com.example.BestBuy.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val productsRepo: ProductsRepository){
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {

        emit(Resource.Loading<List<Product>>())
        try {
            emit(Resource.Success<List<Product>>(data = productsRepo.getAllProducts()))
        }catch (e : HttpException){
            emit(Resource.Error<List<Product>>(message = e.localizedMessage ?: "An unexpected error occurred"))}
        catch (e : IOException){
            emit(Resource.Error<List<Product>>(message = "Couldn't reach server"))}
        catch (e : Exception){
            emit(Resource.Error<List<Product>>(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO) //// Ensure the network request runs on IO dispatcher


}




