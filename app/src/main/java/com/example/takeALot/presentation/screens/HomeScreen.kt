package com.example.takeALot.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.takeALot.presentation.navigation.BottomNav
import com.example.takeALot.presentation.viewmodel.ProductsViewModel
import com.example.takealotclone.R


@Composable
fun HomeScreen (navController: NavController,productsViewModel:ProductsViewModel = hiltViewModel()){

    Scaffold (topBar = { HomeTopBar()},

        bottomBar = {BottomNav(navController)}){ innerPadding ->

        val scrollState = rememberScrollState()
        // The HomeScreen itself is now a Column that is scrollable.
        // It fills the size given to it by the NavHost.
        Column(
            modifier = Modifier
                .fillMaxSize() // Fill the space provided by NavHost
                .verticalScroll(scrollState)
                .padding(innerPadding))

                // Optional: Add some internal padding if sections shouldn't touch edges
            {


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
                    PromoBar(R.drawable.banner1)
                    ProductList(products = uiHomePageState.products,"Mid-Month Essential Deals" ,navController)

                }

                //else -> { Text("No products available") }
            }
        }

    }


}








