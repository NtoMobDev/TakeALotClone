package com.example.bestBuy.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.presentation.navigation.Screen
import com.example.bestBuy.ui.theme.Grey40
import com.example.takealotclone.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.bestBuy.ui.theme.DarkGray
import com.example.bestBuy.ui.theme.LightGray
import com.example.bestBuy.ui.theme.MediumGray


@Composable
fun HomeTopBar(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = LightGray),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top= 24.dp,end = 16.dp, bottom = 8.dp) // Padding for the Box
        ) {
            Image(
                painter = painterResource(id = R.drawable.takealot_logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.Center) // Align to the center of the Box
            )

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.DarkGray,
                modifier = Modifier
                    .align(Alignment.CenterEnd) // Align to the center-end of the Box
            )
        }



        SearchTextField()
    }
}

@Composable
fun SearchTextField() {
    var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = { searchText = it },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search",tint = DarkGray) },
        placeholder = { Text("Search for products,brands...", color = DarkGray) },
        singleLine = true,
        modifier = Modifier
            .defaultMinSize(minHeight = 44.dp)
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 16.dp),
        colors = TextFieldDefaults.colors(focusedContainerColor = MediumGray, unfocusedContainerColor = MediumGray,
            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
fun PromoBar(){}

@Composable
fun ThanksALotPicks(){}

@Composable
fun FeaturedCategories(){}

@Composable
fun DealsOfTheDay(){}

@Composable
fun ProductList(products: List<Product>, navController: NavController) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        userScrollEnabled = false,
        modifier = Modifier.fillMaxSize().height(620.dp), contentPadding = PaddingValues(4.dp)
    )  {
        items(products){ product ->
            ProductCard(product){navController.navigate(Screen.ProductDetails.createRoute(product.id))}

        }
    }
}

@Composable
fun ProductCard(product:Product,onClick :() -> Unit){

    Card(modifier = Modifier
        .height(300.dp)
        .clickable { onClick() },
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Grey40)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = product.image
                , contentDescription = product.title,
                contentScale = ContentScale.Fit, modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp))

            Text(text = product.title, maxLines = 1, overflow = TextOverflow.Clip)
        }


    }

}
