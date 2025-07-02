package com.example.takeALot.di

import com.example.takeALot.data.remote.ApiService
import com.example.takeALot.data.repository.ProductsRepositoryImpl
import com.example.takeALot.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://fakestoreapi.in/api/"

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit:Retrofit):ApiService{
        return  retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(apiService: ApiService) : ProductsRepository{
        return ProductsRepositoryImpl(apiService)
    }
}