package com.example.takeALot.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.takeALot.domain.model.Product
import com.example.takeALot.presentation.viewmodel.SingleProductViewModel
import com.example.takeALot.ui.theme.DarkGray
import com.example.takeALot.ui.theme.LightGray
import com.example.takeALot.ui.theme.PrimaryBlue
import com.example.takeALot.ui.theme.PrimaryGreen

@Composable
fun ProductDetailScreen(navController: NavController, singleProductViewModel: SingleProductViewModel = hiltViewModel()){
    val productPageUiState by singleProductViewModel.productPageState.collectAsState()

   when {
        productPageUiState.isLoading -> { LoadingScreen() }
        productPageUiState.product != null -> { DetailedScreen(productPageUiState.product!!,productPageUiState.relatedProducts,navController) }
        productPageUiState.error != null -> {
            ErrorScreen(message = productPageUiState.error!!)
        }
    }

}

//
@Composable
fun DetailedScreen(product:Product,relatedProducts:List<Product>,navController: NavController) {
    Scaffold(topBar = { DetailedScreenTopBar(navController, product.title) },
        bottomBar = { DetailedScreenBottomBar(product.price) }) { innerPadding ->
        val scrollableState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(scrollableState)
        ) {
            Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
                Column (
                    modifier = Modifier.fillMaxSize().background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = product.image, contentDescription = product.title,
                        contentScale = ContentScale.Fit, modifier = Modifier
                            .fillMaxHeight()
                    )

                }
                Column(modifier = Modifier.align(Alignment.TopStart).padding(top = 16.dp,start=12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)){
                    if (product.discount > 0) {
                        BoxBadge("${product.discount}%\nOFF", PrimaryBlue)
                    }
                    if (product.discount > 10) {
                        BoxBadge("TOP\nPICK", PrimaryGreen)
                    }
                }

        }
            Column(modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp)) {
                Text(
                    product.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(product.brand.uppercase(), color = PrimaryBlue)
                Text(product.model)

                Row {
                    if (product.popular) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Color.Yellow
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(getRating(product.price), fontWeight = FontWeight.Medium)
                    }
                }
            }
            Column(modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp)) {
                Text(text = "R${product.price}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                AdditionalTakeALotInformation()
            }
            ProductList(relatedProducts,"You Might Also Like",navController)
        }


    }
}





@Composable
fun AdditionalTakeALotInformation(){
    Column {
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(text = "Estimated Delivery")
            Spacer(modifier = Modifier.width(4.dp))
            Surface(shape = RectangleShape, color = LightGray, contentColor = DarkGray) {
                Text(text = "CPT", fontWeight = FontWeight.Bold,modifier = Modifier.padding(4.dp))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Surface(shape = RectangleShape, color = LightGray, contentColor = DarkGray) {
                Text(text = "JHB", fontWeight = FontWeight.Bold,modifier = Modifier.padding(4.dp))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Surface(shape = RectangleShape, color = LightGray, contentColor = DarkGray) {
                Text(text = "DBN", fontWeight = FontWeight.Bold,modifier = Modifier.padding(4.dp))
            }


        }
        Row { Text("Get it Tomorrow!", fontWeight = FontWeight.Bold)
        Text(text = "T&Cs Apply", color = PrimaryBlue, fontWeight = FontWeight.Bold, modifier = Modifier.clickable {  })}
        Row {

        }
    }
}

@Composable
fun YouMightAlsoLike(){

}
