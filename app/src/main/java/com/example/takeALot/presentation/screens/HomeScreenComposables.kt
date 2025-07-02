package com.example.takeALot.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.takeALot.domain.model.Product
import com.example.takeALot.presentation.navigation.Screen
import com.example.takeALot.ui.theme.Grey40
import com.example.takealotclone.R
import androidx.compose.ui.text.font.FontWeight
import com.example.takeALot.ui.theme.DarkGray
import com.example.takeALot.ui.theme.PrimaryBlue
import com.example.takeALot.ui.theme.PrimaryGreen


@Composable
fun PromoBar(promoBarImage:Int){
    Row(modifier = Modifier.fillMaxWidth().height(300.dp)){
        Image(painter = painterResource(promoBarImage),contentDescription = "Banner"
            ,contentScale = ContentScale.FillWidth, modifier = Modifier.fillMaxWidth().height(300.dp))
    }

}

@Composable
fun ThanksALotPicks(){}



@Composable
fun FeaturedCategories(categories:List<String>,navController: NavController){
   /*val predefinedBackgroundColors = listOf(
        Color(0xFFFA595E),
        Color(0xFF07213A),
        Color(0xFF0076D6),
        Color(0xFF28A745)
    )*/
   val takeALotCategories = listOf(
        "MORE Deals"
      )

  val allCategories = takeALotCategories + categories

    val allCategoriesImages = listOf(R.drawable.moredeals_category,
        R.drawable.tv_category,R.drawable.audio_category, R.drawable.laptop_category,
        R.drawable.phone_category,R.drawable.appliance_category,)
    Column (modifier = Modifier.fillMaxWidth().background(Color.White)){
        Text(
            text = "Featured Categories",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )
        LazyRow(modifier = Modifier.background(Color.White)) {

            itemsIndexed(allCategories) { index, category ->
                CategorySection(category, allCategoriesImages[index]){
                    navController.navigate(Screen.CategoryDetails.createRoute(category))}
            }
            /*items(categories){ category ->
            CategorySection(category)*/
        }
    }
    }


@Composable
fun CategorySection(category:String,imagePosition:Int,onClick: () -> Unit){
    Column (modifier = Modifier.padding(16.dp).clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = imagePosition),contentDescription = category)
        Text(text = category)}

}

@Composable
fun DealsOfTheDay(){}

@Composable
fun ProductList(products: List<Product>, title:String,navController: NavController) {
    Column (modifier = Modifier.background(Color.White)){
        Text(text = title, modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            userScrollEnabled = false,
            modifier = Modifier.fillMaxSize().height(620.dp), contentPadding = PaddingValues(4.dp)
        )  {
            items(products){ product ->
                ProductCard(product){navController.navigate(Screen.ProductDetails.createRoute(product.id,product.category))}

            }
        }
    }

}

@Composable
fun ProductCard(product:Product,onClick :() -> Unit) {

    Card(
        modifier = Modifier
            .height(300.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Grey40)
    ) {
        Box (modifier = Modifier.fillMaxSize()){
            Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.image, contentDescription = product.title,
                contentScale = ContentScale.Fit, modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            )

            Text(text = product.title, maxLines = 1, overflow = TextOverflow.Clip)
            Text(text = "R${product.price}", fontWeight = FontWeight.Bold)
                if (product.popular) {
                    Row { Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Color.Yellow
                    )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(getRating(product.price), fontWeight = FontWeight.Medium) }



            }



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
            Column(modifier = Modifier.align(Alignment.TopEnd).padding(top = 16.dp, end =12.dp).clickable {  },
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Add to List",tint = DarkGray)
            }


        }


    }
}

fun getRating(price:Int):String{
    val rating = "4.${price.toString().substring(0,1)}"
    return rating
}

private fun getReviews():String{
    val randomNumber = (9..60).random()
    return "$randomNumber REVIEWS"
}
