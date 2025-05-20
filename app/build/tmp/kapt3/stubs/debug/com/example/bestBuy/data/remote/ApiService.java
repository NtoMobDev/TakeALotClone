package com.example.bestBuy.data.remote;

import com.example.bestBuy.data.dto.CategoryDto;
import com.example.bestBuy.data.dto.ResponseDto;
import com.example.bestBuy.data.dto.SingleProductDto;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/example/bestBuy/data/remote/ApiService;", "", "getAllCategories", "Lcom/example/bestBuy/data/dto/CategoryDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllProducts", "Lcom/example/bestBuy/data/dto/ResponseDto;", "getLimitedProducts", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSingleProduct", "Lcom/example/bestBuy/data/dto/SingleProductDto;", "id", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllProducts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.bestBuy.data.dto.ResponseDto> $completion);
    
    @retrofit2.http.GET(value = "products/category")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.bestBuy.data.dto.CategoryDto> $completion);
    
    @retrofit2.http.GET(value = "products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLimitedProducts(@retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.bestBuy.data.dto.ResponseDto> $completion);
    
    @retrofit2.http.GET(value = "products/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSingleProduct(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.bestBuy.data.dto.SingleProductDto> $completion);
}