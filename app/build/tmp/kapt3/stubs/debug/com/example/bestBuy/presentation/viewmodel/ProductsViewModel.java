package com.example.bestBuy.presentation.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.lifecycle.ViewModel;
import com.example.bestBuy.common.Resource;
import com.example.bestBuy.domain.usecases.GetAllProductsUseCase;
import com.example.bestBuy.domain.usecases.GetCategoriesUseCase;
import com.example.bestBuy.domain.usecases.GetHomePageProductsUseCase;
import com.example.bestBuy.domain.usecases.GetSingleProductUseCase;
import com.example.bestBuy.presentation.state.CategoryUiState;
import com.example.bestBuy.presentation.state.ProductsUiState;
import com.example.bestBuy.presentation.state.SingleProductUiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/example/bestBuy/presentation/viewmodel/ProductsViewModel;", "Landroidx/lifecycle/ViewModel;", "getProducts", "Lcom/example/bestBuy/domain/usecases/GetAllProductsUseCase;", "getHomePageProductsUseCase", "Lcom/example/bestBuy/domain/usecases/GetHomePageProductsUseCase;", "(Lcom/example/bestBuy/domain/usecases/GetAllProductsUseCase;Lcom/example/bestBuy/domain/usecases/GetHomePageProductsUseCase;)V", "_uiCategoriesState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bestBuy/presentation/state/CategoryUiState;", "_uiProductsState", "Lcom/example/bestBuy/presentation/state/ProductsUiState;", "uiCategoriesState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiCategoriesState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiProductsState", "getUiProductsState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProductsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.bestBuy.domain.usecases.GetAllProductsUseCase getProducts = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.bestBuy.domain.usecases.GetHomePageProductsUseCase getHomePageProductsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.bestBuy.presentation.state.ProductsUiState> _uiProductsState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.bestBuy.presentation.state.ProductsUiState> uiProductsState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.bestBuy.presentation.state.CategoryUiState> _uiCategoriesState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.bestBuy.presentation.state.CategoryUiState> uiCategoriesState = null;
    
    @javax.inject.Inject()
    public ProductsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.bestBuy.domain.usecases.GetAllProductsUseCase getProducts, @org.jetbrains.annotations.NotNull()
    com.example.bestBuy.domain.usecases.GetHomePageProductsUseCase getHomePageProductsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.bestBuy.presentation.state.ProductsUiState> getUiProductsState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.bestBuy.presentation.state.CategoryUiState> getUiCategoriesState() {
        return null;
    }
}