package com.example.bestBuy.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestBuy.common.Resource
import com.example.bestBuy.domain.usecases.GetSingleProductUseCase
import com.example.bestBuy.presentation.state.SingleProductUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleProductViewModel @Inject constructor(private  val getSingleProductUseCase: GetSingleProductUseCase,
                                                 savedStateHandle: SavedStateHandle): ViewModel() {

    private var _uiProductState by mutableStateOf(SingleProductUiState())
    var uiProductUiState = _uiProductState

    init {
        val productId = savedStateHandle.get<Int>("id")
        if (productId != null) {
            fetchProduct(productId)
        } else {
            _uiProductState = _uiProductState.copy(error = "Missing or Invalid product ID")
        }
    }

    private fun fetchProduct(id: Int) {
        viewModelScope.launch {
            _uiProductState = _uiProductState.copy(isLoading = true)

            when (val result = getSingleProductUseCase(id)) {
                is Resource.Success -> {
                    _uiProductState = _uiProductState.copy(product = result.data, isLoading = false)
                }
                is Resource.Error -> {
                    _uiProductState = _uiProductState.copy(error = result.message, isLoading = false)
                }
                else -> {}
            }
        }

    }
}