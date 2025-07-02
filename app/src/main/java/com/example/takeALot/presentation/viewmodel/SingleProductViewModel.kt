package com.example.takeALot.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takeALot.common.Resource

import com.example.takeALot.domain.usecases.GetProductsByCategoryUseCase
import com.example.takeALot.domain.usecases.GetSingleProductUseCase
import com.example.takeALot.presentation.state.SingleProductPageUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class SingleProductViewModel @Inject constructor(private  val getSingleProductUseCase: GetSingleProductUseCase,
                                                 private val getProductsByCategoryUseCase: GetProductsByCategoryUseCase,
                                                 savedStateHandle: SavedStateHandle): ViewModel() {

    private val productId: Int = checkNotNull(savedStateHandle["itemId"])
    private val productCategory: String = checkNotNull(savedStateHandle["categoryName"])

    private val _uiSingleProductPageState =
        MutableStateFlow<SingleProductPageUiState>(SingleProductPageUiState())
    val productPageState: StateFlow<SingleProductPageUiState> = _uiSingleProductPageState


    init {
        loadProductData()
    }

    private fun loadProductData() {
        viewModelScope.launch {
            val productFlow = getSingleProductUseCase(productId)

            val relatedProductsFlow =
                getProductsByCategoryUseCase(productCategory).map { resource ->
                    when (resource) {
                        is Resource.Success -> {
                            val filteredList =
                                resource.data?.filter { product -> product.id != productId }
                                    ?: emptyList() // Handle null data, though ideally it shouldn't be null on Success
                            // 2. Shuffle the filtered list to randomize the order
                            val shuffledList = filteredList.shuffled() // [1]
                            val randomTwoProducts = shuffledList.take(2)
                            Resource.Success(randomTwoProducts)
                        }

                        is Resource.Error -> resource
                        is Resource.Loading -> resource
                    }
                }

            combine(productFlow, relatedProductsFlow) { productResource, relatedProductsResource ->
                when {
                    productResource is Resource.Success && relatedProductsResource is Resource.Success -> {
                        val product = productResource.data
                        val relatedProducts = relatedProductsResource.data ?: emptyList()
                        SingleProductPageUiState(product = product, relatedProducts = relatedProducts,isLoading = false)
                    }
                    productResource is Resource.Error || relatedProductsResource is Resource.Error -> {
                        val productError = (productResource as? Resource.Error)?.message
                        val relatedProductsError = (relatedProductsResource as? Resource.Error)?.message
                        val combinedError = listOfNotNull(productError, relatedProductsError)
                            .joinToString("; ")
                            .ifEmpty { "An unknown error occurred while loading data." }
                        SingleProductPageUiState(error = combinedError, isLoading = false)
                    }
                    else -> SingleProductPageUiState(isLoading = true)
                }


            }
                .onStart {_uiSingleProductPageState.value = _uiSingleProductPageState.value.copy(isLoading = true)}
                .catch { e ->_uiSingleProductPageState.value = _uiSingleProductPageState.value.copy(error = e.message ?: "An unexpected system error occurred.", isLoading = false)}
                .collect{ resultingUiState ->_uiSingleProductPageState.value = resultingUiState}
        }
    }
}




