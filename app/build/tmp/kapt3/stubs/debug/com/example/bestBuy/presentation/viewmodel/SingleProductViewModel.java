package com.example.bestBuy.presentation.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.bestBuy.common.Resource;
import com.example.bestBuy.domain.model.Product;
import com.example.bestBuy.domain.usecases.GetSingleProductUseCase;
import com.example.bestBuy.presentation.state.ProductsUiState;
import com.example.bestBuy.presentation.state.SingleProductUiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/bestBuy/presentation/viewmodel/SingleProductViewModel;", "Landroidx/lifecycle/ViewModel;", "getSingleProductUseCase", "Lcom/example/bestBuy/domain/usecases/GetSingleProductUseCase;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/bestBuy/domain/usecases/GetSingleProductUseCase;Landroidx/lifecycle/SavedStateHandle;)V", "_uiProductState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bestBuy/presentation/state/SingleProductUiState;", "productId", "", "productState", "Lkotlinx/coroutines/flow/StateFlow;", "getProductState", "()Lkotlinx/coroutines/flow/StateFlow;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SingleProductViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.bestBuy.domain.usecases.GetSingleProductUseCase getSingleProductUseCase = null;
    private final int productId = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.bestBuy.presentation.state.SingleProductUiState> _uiProductState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.bestBuy.presentation.state.SingleProductUiState> productState = null;
    
    @javax.inject.Inject()
    public SingleProductViewModel(@org.jetbrains.annotations.NotNull()
    com.example.bestBuy.domain.usecases.GetSingleProductUseCase getSingleProductUseCase, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.bestBuy.presentation.state.SingleProductUiState> getProductState() {
        return null;
    }
}