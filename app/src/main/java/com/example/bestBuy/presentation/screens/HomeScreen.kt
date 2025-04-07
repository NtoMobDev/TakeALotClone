package com.example.bestBuy.presentation.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.presentation.state.ProductsUiState
import com.example.bestBuy.presentation.viewmodel.ProductsViewModel
import com.example.bestBuy.ui.theme.Grey40
import com.example.bestBuy.ui.theme.Pink80

@Composable
fun HomeScreen (modifier: Modifier,productsViewModel:ProductsViewModel = hiltViewModel()){
    val uiProductsState by productsViewModel.uiProductsState.collectAsStateWithLifecycle()
        when {
            uiProductsState.isLoading -> { LoadingScreen() }
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
      verticalArrangement = Arrangement.spacedBy(16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp),
      modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(4.dp)
  )  {
      items(products){ product ->
          ProductCard(product)

      }
  }
}

@Composable
fun ProductCard(product:Product){
    Card(modifier = Modifier.height(200.dp),
        shape = RoundedCornerShape(5.dp), colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Grey40)) {
        AsyncImage(model = product.image, contentDescription = product.title,
            contentScale = ContentScale.Crop, modifier = Modifier.size(100.dp))
        Text(text = product.title, maxLines = 1, overflow = TextOverflow.Clip)

    }

}


@Composable
fun ErrorScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message, color = Color.Cyan)
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
       CircularProgressIndicator(color = Pink80)
    }
}
