package com.example.bestBuy.domain.usecases

import com.example.bestBuy.common.Resource
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.domain.repository.ProductsRepository
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
            emit(Resource.Error<List<Product>>(message ="Couldn't reach server"))}
        catch (e : Exception){
            emit(Resource.Error<List<Product>>(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO) //// Ensure the network request runs on IO dispatcher

}


class GetHomePageProductsUseCase @Inject constructor (private val productsRepo: ProductsRepository){
    operator fun invoke(limit:Int):Flow<Resource<List<Product>>> = flow{
        emit(Resource.Loading<List<Product>>())
        try {
            emit(Resource.Success<List<Product>>(data = productsRepo.getHomePageProductList(limit)))
        }catch (e : HttpException){
            emit(Resource.Error<List<Product>>(message = e.localizedMessage ?: "An unexpected error occurred"))}
        catch (e : IOException){
            emit(Resource.Error<List<Product>>(message = e.message.toString()))}
        catch (e : Exception){
            emit(Resource.Error<List<Product>>(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO) //// Ensure the network request runs on IO dispatcher


}

class GetCategoriesUseCase @Inject constructor(private val productsRepo: ProductsRepository){
    operator  fun invoke(): Flow<Resource<List<String>>> = flow{
        emit(Resource.Loading<List<String>>())
        try {
            emit(Resource.Success<List<String>>(data = productsRepo.getAllCategories()))
        }catch (e : HttpException){
            emit(Resource.Error<List<String>>(message = e.localizedMessage ?: "An unexpected error occurred"))}
        catch (e : IOException){
            emit(Resource.Error<List<String>>(message = "Couldn't reach server"))}
        catch (e : Exception){
            emit(Resource.Error<List<String>>(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO) //// Ensure the network request runs on IO dispatcher


}

class GetSingleProductUseCase @Inject constructor(private val productsRepo: ProductsRepository){
     suspend operator  fun invoke(id:Int):Resource<Product>{
        return try {
            Resource.Success(data = productsRepo.getSingleProduct(id))
        } catch (e : Exception){
            Resource.Error(message = e.message.toString())
        }
    }
}






