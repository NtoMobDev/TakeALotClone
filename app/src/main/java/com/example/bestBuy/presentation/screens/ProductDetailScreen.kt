package com.example.bestBuy.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bestBuy.domain.model.Product
import com.example.bestBuy.presentation.viewmodel.SingleProductViewModel
import com.example.bestBuy.ui.theme.Peach40

@Composable
fun ProductDetailScreen(navController: NavController, singleProductViewModel: SingleProductViewModel = hiltViewModel()){
    val productUiState by singleProductViewModel.productState.collectAsState()

   when {
        productUiState.isLoading -> { LoadingScreen() }
        productUiState.product != null -> { DetailedScreen(productUiState.product!!,navController) }
        productUiState.error != null -> {
            ErrorScreen(message = productUiState.error!!)
        }
    }

}

//
@Composable
fun DetailedScreen(product:Product,navController: NavController) {
    Scaffold(topBar = { DetailedScreenTopBar(navController, product.title) },
        bottomBar = { DetailedScreenBottomBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Text(product.title)
        }
    }
}



@Composable
fun DetailedScreenTopBar(navController: NavController,productTitle:String){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){

        Icon(imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Back", tint = Peach40,
            modifier = Modifier.size(40.dp).padding(8.dp).clickable { navController.popBackStack() })
        Text(text =productTitle.substringAfter(""),maxLines = 1,overflow = TextOverflow.Ellipsis,style = MaterialTheme.typography.titleSmall)
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Peach40,
            modifier = Modifier.size(40.dp).padding(8.dp).clickable {  })


    }

}

@Composable
fun DetailedScreenBottomBar(){

}