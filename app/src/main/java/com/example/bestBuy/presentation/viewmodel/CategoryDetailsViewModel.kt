package com.example.bestBuy.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestBuy.common.Resource
import com.example.bestBuy.domain.usecases.GetProductsByCategoryUseCase
import com.example.bestBuy.presentation.state.ProductsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CategoryDetailsViewModel @Inject constructor(
    private val getProductsByCategoryUseCase: GetProductsByCategoryUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

        val categoryName: String = checkNotNull(savedStateHandle["categoryName"])

    private val _uiCategoryProductsState = MutableStateFlow<ProductsUiState>(ProductsUiState())
    val uiCategoryProductsState: StateFlow<ProductsUiState> = _uiCategoryProductsState

    init {
        getProductsByCategoryUseCase(categoryName).onEach{result->
            when(result){
                is Resource.Loading->{
                    //Emit new values reactively – When you update .value, it notifies all collectors.
                    _uiCategoryProductsState.value = ProductsUiState(isLoading = true)
                }
                is Resource.Success->{
                    _uiCategoryProductsState.value = ProductsUiState(products = result.data ?: emptyList(), isLoading = false)
                }
                is Resource.Error->{
                    _uiCategoryProductsState.value = ProductsUiState(error = result.message.toString(), isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }



}

