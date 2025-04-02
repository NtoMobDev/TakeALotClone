package com.example.bestBuy.presentation.screens


import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.Card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.presentation.state.ProductsUiState
import com.example.bestBuy.presentation.viewmodel.ProductsViewModel

@Composable
fun HomeScreen (productsViewModel:ProductsViewModel = hiltViewModel(),modifier: Modifier){
    val uiProductsState by productsViewModel.uiProductsState.collectAsStateWithLifecycle()

        when {
            uiProductsState.isLoading -> {   Text("Loading") }
            uiProductsState.error != null -> { ErrorScreen(message = uiProductsState.error ?: "Unknown error") }
            uiProductsState.products.isNotEmpty() -> {
                ProductList(products = uiProductsState.products)
            }
            else -> { Text("No products available") }
        }
}

@Composable
fun ProductList(products: List<Product>) {
  LazyVerticalGrid(columns = GridCells.Fixed(2),
      modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(4.dp)
  )  {
      items(products){ product ->
          ProductCard(product)

      }
  }

}

@Composable
fun ProductCard(product:Product){
    Card(modifier = Modifier.size(width = 100.dp, height = 200.dp)) {
        AsyncImage(model = product.image, contentDescription = product.title,
            contentScale = ContentScale.Crop, modifier = Modifier.size(100.dp))
        Text(text = product.title)

    }

}


@Composable
fun ErrorScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message, color = Color.Cyan)
    }
}
