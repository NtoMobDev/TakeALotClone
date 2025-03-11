package com.example.BestBuy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.BestBuy.common.Resource
import com.example.BestBuy.domain.usecases.GetAllProductsUseCase
import com.example.BestBuy.presentation.state.ProductsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProducts: GetAllProductsUseCase): ViewModel(){
    private val _uiProductsState = MutableStateFlow<ProductsUiState>(ProductsUiState())
    val uiProductsState : StateFlow<ProductsUiState> = _uiProductsState

    init {//productListUseCase.invoke().onEach
        getProducts.invoke().onEach{result->
            when(result){
                is Resource.Loading->{
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