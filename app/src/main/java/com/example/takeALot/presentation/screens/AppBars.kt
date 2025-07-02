package com.example.takeALot.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.takeALot.ui.theme.DarkGray
import com.example.takeALot.ui.theme.LightGray
import com.example.takeALot.ui.theme.MediumGray
import com.example.takeALot.ui.theme.PrimaryBlue
import com.example.takeALot.ui.theme.PrimaryGreen
import com.example.takealotclone.R

@Composable
fun HomeTopBar(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = LightGray),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        AppLogo()
        SearchTextField()
    }
}

@Composable
fun AppLogo(){
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
            .defaultMinSize(minHeight = 36.dp)
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 16.dp),
        colors = TextFieldDefaults.colors(focusedContainerColor = MediumGray, unfocusedContainerColor = MediumGray,
            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
fun DetailedScreenTopBar(navController: NavController, title:String){
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        val displayTitle = title.split(' ').take(2).joinToString(" ")


        Icon(imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Back", tint = PrimaryBlue,
            modifier = Modifier.size(40.dp).padding(8.dp).clickable { navController.popBackStack() })
        Text(text ="$displayTitle..." ,maxLines = 1,
            style = MaterialTheme.typography.titleLarge,fontWeight = FontWeight.Bold)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search",
                tint = Color.DarkGray,modifier = Modifier.size(40.dp).padding(8.dp).clickable {  })
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.DarkGray,
                modifier = Modifier.size(40.dp).padding(8.dp).clickable {  }) }



    }

}

@Composable
fun DetailedScreenBottomBar(price:Int){
    Surface(modifier = Modifier.fillMaxWidth(), color = LightGray, tonalElevation = 20.dp) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Price: R$price",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row {
                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = LightGray,
                        contentColor = DarkGray
                    )
                ) {
                    Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Back")
                }
                IconButton(
                    onClick = {}, modifier = Modifier.weight(1f),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = PrimaryGreen,
                        contentColor = Color.White
                    )
                ) {
                    Row() {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add to Cart")
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                        Text(text = "Add to Cart")
                    }

                }
            }

        }

    }

}

@Composable
fun AppTopBar(title:String){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically){
            Icon(imageVector = Icons.Default.Search,contentDescription = "Search", tint = Color.DarkGray)
            Icon(imageVector = Icons.Default.ShoppingCart,contentDescription = "Cart", tint = Color.DarkGray)
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = title, style = MaterialTheme.typography.titleLarge, color = Color.Black)
        }

    }
}