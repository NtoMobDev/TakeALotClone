package com.example.bestBuy.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.presentation.navigation.Screen
import com.example.bestBuy.ui.theme.Grey40

@Composable
fun HomeTopBar(){}

@Composable
fun PromoBar(){}

@Composable
fun CategorySection(){}

@Composable
fun FeaturedProducts(){}

@Composable
fun DealsOfTheDay(){}

@Composable
fun ProductList(products: List<Product>, navController: NavController) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(4.dp)
    )  {
        items(products){ product ->
            ProductCard(product){navController.navigate(Screen.ProductDetails.createRoute(product.id))}

        }
    }
}

@Composable
fun ProductCard(product:Product,onClick :() -> Unit){

    Card(modifier = Modifier.height(300.dp).clickable { onClick() },
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Grey40)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = product.image
                , contentDescription = product.title,
                contentScale = ContentScale.Fit, modifier = Modifier.fillMaxWidth().height(160.dp))

            Text(text = product.title, maxLines = 1, overflow = TextOverflow.Clip)
        }


    }

}
