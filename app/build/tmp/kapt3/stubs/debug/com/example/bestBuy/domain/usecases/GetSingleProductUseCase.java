package com.example.bestBuy.domain.usecases;

import com.example.bestBuy.common.Resource;
import com.example.bestBuy.domain.model.Product;
import com.example.bestBuy.domain.repository.ProductsRepository;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/bestBuy/domain/usecases/GetSingleProductUseCase;", "", "productsRepo", "Lcom/example/bestBuy/domain/repository/ProductsRepository;", "(Lcom/example/bestBuy/domain/repository/ProductsRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/bestBuy/common/Resource;", "Lcom/example/bestBuy/domain/model/Product;", "id", "", "app_debug"})
public final class GetSingleProductUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.example.bestBuy.domain.repository.ProductsRepository productsRepo = null;
    
    @javax.inject.Inject()
    public GetSingleProductUseCase(@org.jetbrains.annotations.NotNull()
    com.example.bestBuy.domain.repository.ProductsRepository productsRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.bestBuy.common.Resource<com.example.bestBuy.domain.model.Product>> invoke(int id) {
        return null;
    }
}