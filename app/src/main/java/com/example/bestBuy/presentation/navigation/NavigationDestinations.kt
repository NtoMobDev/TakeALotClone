package com.example.bestBuy.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

//define destinations
sealed class Screen(val route:String,val title:String,val icon:ImageVector){
    object Home : Screen("home","Home", Icons.Sharp.Home)
    object Cart : Screen("cart","Cart",Icons.Sharp.ShoppingCart)
    object Profile : Screen("profile","Profile",Icons.Sharp.Person)
    object Search: Screen("search","Search",Icons.Sharp.Search)
    object ProductDetails : Screen("products/{itemId}","Details",Icons.Sharp.Info) {
        fun createRoute(itemId: Int) = "products/$itemId"
    }
}

