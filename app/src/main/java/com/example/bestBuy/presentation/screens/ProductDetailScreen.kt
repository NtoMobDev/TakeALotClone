package com.example.bestBuy.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.presentation.state.ProductsUiState
import com.example.bestBuy.presentation.viewmodel.SingleProductViewModel

@Composable
fun ProductDetailScreen(singleProductViewModel: SingleProductViewModel = hiltViewModel()){
    val productUiState = singleProductViewModel.uiProductUiState

    when {
        productUiState.isLoading -> { LoadingScreen() }
        productUiState.product != null -> {DetailedScreen(productUiState.product)}
        productUiState.error != null -> {
            ErrorScreen(message = productUiState.error)
        }
    }

}

@Composable
fun DetailedScreen(product:Product){
    Text(product.title)


}