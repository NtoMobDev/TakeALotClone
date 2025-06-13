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
import com.example.bestBuy.presentation.state.HomePageUiState
import com.example.bestBuy.presentation.state.ProductsUiState
import com.example.bestBuy.presentation.state.SingleProductUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getCategoriesUseCase:GetCategoriesUseCase,
   private val getHomePageProductsUseCase: GetHomePageProductsUseCase ): ViewModel(){
    //Always holds a value – Unlike LiveData, MutableStateFlow requires an initial value.



    private val _uiHomeState = MutableStateFlow<HomePageUiState>(HomePageUiState())
    val uiHomeState : StateFlow<HomePageUiState> = _uiHomeState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData(){
        viewModelScope.launch {
            getCategoriesUseCase()
                .combine(getHomePageProductsUseCase(4)){ categories,products->
                    if (categories is Resource.Success && products is Resource.Success){
                        val categoriesData = categories.data ?: emptyList()
                        val productsData = products.data ?: emptyList()
                        HomePageUiState(
                            categories = categoriesData,
                            products = productsData,
                            isLoading = false )// Data loaded successfully
                    } else {
                        val categoriesError = (categories as? Resource.Error)?.message
                        val productsError = (products as? Resource.Error)?.message
                        val combinedError = listOfNotNull(categoriesError, productsError)
                            .joinToString("; ")
                            .ifEmpty { "An unknown error occurred while loading data." }

                        HomePageUiState(
                            // Preserve successfully loaded data if one part failed
                            categories = (categories as? Resource.Success)?.data
                                ?: _uiHomeState.value.categories,
                            products = (products as? Resource.Success)?.data
                                ?: _uiHomeState.value.products,
                            error = combinedError,
                            isLoading = false )// Attempt finished, even if with an error
                    }

            }
                .onStart {
                    // When the flow collection starts, EMIT a loading state.
                    // Preserve existing data if you want to show stale data while loading.
                    _uiHomeState.value = _uiHomeState.value.copy(
                        isLoading = true,
                        error = null
                    )
                }
                .catch { e ->
                    // If any exception occurs in the upstream flow (use cases, combine)
                    // that wasn't handled as a Resource.Error, catch it here and EMIT an error state.
                    _uiHomeState.value = _uiHomeState.value.copy(
                        error = e.message ?: "An unexpected system error occurred.",
                        isLoading = false
                    )
                    
                }
                .collect { resultingUiState ->
                    // 'resultingUiState' is the HomePageUiState emitted by onStart,
                    // the combine block, or the catch block.
                    // Assign this complete state to your MutableStateFlow.
                    _uiHomeState.value = resultingUiState
                }
        }
    }
}