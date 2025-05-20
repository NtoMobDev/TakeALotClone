package com.example.bestBuy.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestBuy.common.Resource
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.domain.usecases.GetSingleProductUseCase
import com.example.bestBuy.presentation.state.ProductsUiState
import com.example.bestBuy.presentation.state.SingleProductUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleProductViewModel @Inject constructor(private  val getSingleProductUseCase: GetSingleProductUseCase,
                                                 savedStateHandle: SavedStateHandle): ViewModel() {

    private val productId: Int = checkNotNull(savedStateHandle["itemId"])

    private val _uiProductState = MutableStateFlow<SingleProductUiState>(SingleProductUiState())
    val productState: StateFlow<SingleProductUiState> = _uiProductState

    init {
        getSingleProductUseCase(productId).onEach{result->
            when(result){
                is Resource.Loading->{
                    //Emit new values reactively – When you update .value, it notifies all collectors.
                    _uiProductState.value = SingleProductUiState(isLoading = true)
                }
                is Resource.Success->{
                    _uiProductState.value = SingleProductUiState(product = result.data, isLoading = false)
                }
                is Resource.Error->{
                    _uiProductState.value = SingleProductUiState(error = result.message.toString(), isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }
}