package com.example.bestBuy.presentation.screens

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.bestBuy.presentation.viewmodel.ProductsViewModel


@Composable
fun HomeScreen (navController: NavController,productsViewModel:ProductsViewModel = hiltViewModel()){
    val uiProductsState by productsViewModel.uiProductsState.collectAsStateWithLifecycle()
        when {
            uiProductsState.isLoading -> { LoadingScreen() }
            uiProductsState.error != null -> { ErrorScreen(message = uiProductsState.error ?: "Unknown error") }
            uiProductsState.products.isNotEmpty() -> {
                ProductList(products = uiProductsState.products,navController)
            }
            //else -> { Text("No products available") }
        }
}






