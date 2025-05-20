package com.example.bestBuy.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestBuy.common.Resource
import com.example.bestBuy.domain.usecases.GetAllProductsUseCase
import com.example.bestBuy.domain.usecases.GetCategoriesUseCase
import com.example.bestBuy.domain.usecases.GetHomePageProductsUseCase
import com.example.bestBuy.domain.usecases.GetSingleProductUseCase
import com.example.bestBuy.presentation.state.CategoryUiState
import com.example.bestBuy.presentation.state.ProductsUiState
import com.example.bestBuy.presentation.state.SingleProductUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProducts: GetAllProductsUseCase,
   private val getHomePageProductsUseCase: GetHomePageProductsUseCase ): ViewModel(){
    //Always holds a value – Unlike LiveData, MutableStateFlow requires an initial value.
    private val _uiProductsState = MutableStateFlow<ProductsUiState>(ProductsUiState())
    val uiProductsState : StateFlow<ProductsUiState> = _uiProductsState.asStateFlow()

    private val _uiCategoriesState = MutableStateFlow<CategoryUiState>(CategoryUiState())
    val uiCategoriesState : StateFlow<CategoryUiState> = _uiCategoriesState.asStateFlow()


    init {
        getHomePageProductsUseCase(8).onEach{result->
            when(result){
                is Resource.Loading->{
                    //Emit new values reactively – When you update .value, it notifies all collectors.
                    _uiProductsState.value = ProductsUiState(isLoading = true)
                }
                is Resource.Success->{
                    _uiProductsState.value = ProductsUiState(products = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _uiProductsState.value = ProductsUiState(error = result.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }


    
}