package com.example.bestBuy.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.presentation.viewmodel.CategoryDetailsViewModel

@Composable
fun CategoryDetailScreen(navController: NavController,
                         categoryDetailsViewModel: CategoryDetailsViewModel = hiltViewModel()) {

    val uiCategoryState by categoryDetailsViewModel.uiCategoryProductsState.collectAsState()

    when {
        uiCategoryState.isLoading -> { LoadingScreen() }
        uiCategoryState.products.isNotEmpty() -> { CategoryDetails(uiCategoryState.products,navController) }
        uiCategoryState.error != null -> {
        ErrorScreen(message = uiCategoryState.error!!)
    }
    }

}

@Composable
fun CategoryDetails(products: List<Product>,navController: NavController) {
    Scaffold() { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            ProductList(products,navController)
        }

    }

}

