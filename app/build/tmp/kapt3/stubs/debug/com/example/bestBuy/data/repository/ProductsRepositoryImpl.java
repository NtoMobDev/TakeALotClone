package com.example.bestBuy.data.repository;

import com.example.bestBuy.data.remote.ApiService;
import com.example.bestBuy.domain.repository.ProductsRepository;
import com.example.bestBuy.domain.model.Product;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0096@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0010\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/bestBuy/data/repository/ProductsRepositoryImpl;", "Lcom/example/bestBuy/domain/repository/ProductsRepository;", "productsApi", "Lcom/example/bestBuy/data/remote/ApiService;", "(Lcom/example/bestBuy/data/remote/ApiService;)V", "getAllCategories", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllProducts", "Lcom/example/bestBuy/domain/model/Product;", "getHomePageProductList", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductsByCategory", "category", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSingleProduct", "id", "app_debug"})
public final class ProductsRepositoryImpl implements com.example.bestBuy.domain.repository.ProductsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.bestBuy.data.remote.ApiService productsApi = null;
    
    @javax.inject.Inject()
    public ProductsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.bestBuy.data.remote.ApiService productsApi) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAllProducts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.bestBuy.domain.model.Product>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAllCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getHomePageProductList(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.bestBuy.domain.model.Product>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSingleProduct(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.bestBuy.domain.model.Product> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getProductsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.bestBuy.domain.model.Product>> $completion) {
        return null;
    }
}