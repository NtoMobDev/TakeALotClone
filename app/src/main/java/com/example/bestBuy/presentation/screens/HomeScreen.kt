package com.example.bestBuy.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.bestBuy.presentation.viewmodel.ProductsViewModel


@Composable
fun HomeScreen (navController: NavController,productsViewModel:ProductsViewModel = hiltViewModel()){

    val scrollState = rememberScrollState()

    // The HomeScreen itself is now a Column that is scrollable.
    // It fills the size given to it by the NavHost.
    Column(
        modifier = Modifier
            .fillMaxSize() // Fill the space provided by NavHost
            .verticalScroll(scrollState)
            // Optional: Add some internal padding if sections shouldn't touch edges
            .padding(8.dp)) {


        val uiHomePageState by productsViewModel.uiHomeState.collectAsStateWithLifecycle()
        when {
            uiHomePageState.isLoading -> {
                LoadingScreen()
            }

            uiHomePageState.error != null -> {
                ErrorScreen(message = uiHomePageState.error ?: "Unknown error")
            }

            uiHomePageState.products.isNotEmpty() and uiHomePageState.categories.isNotEmpty() -> {
                FeaturedCategories(categories = uiHomePageState.categories,navController)
                ProductList(products = uiHomePageState.products, navController)

            }

            //else -> { Text("No products available") }
        }
    }
}








