package com.example.takeALot.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.takeALot.domain.model.Product
import com.example.takeALot.presentation.viewmodel.CategoryDetailsViewModel

@Composable
fun CategoryDetailScreen(navController: NavController,
                         categoryDetailsViewModel: CategoryDetailsViewModel = hiltViewModel()) {

    val uiCategoryState by categoryDetailsViewModel.uiCategoryProductsState.collectAsState()

    when {
        uiCategoryState.isLoading -> { LoadingScreen() }
        uiCategoryState.products.isNotEmpty() -> { CategoryDetails(navController,uiCategoryState.products) }
        uiCategoryState.error != null -> {
        ErrorScreen(message = uiCategoryState.error!!)
    }
    }

}

@Composable
fun CategoryDetails(navController: NavController,products: List<Product>) {
    Scaffold(
        topBar = { DetailedScreenTopBar(navController, products[0].category) })
    { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            ProductList(products,"Shop by Category",navController)
        }

    }

}

