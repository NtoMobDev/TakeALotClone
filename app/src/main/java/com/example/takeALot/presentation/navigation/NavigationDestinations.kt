package com.example.takeALot.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ManageSearch
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Info
import androidx.compose.ui.graphics.vector.ImageVector

//define destinations
sealed class Screen(val route:String,val title:String,val icon:ImageVector){
    object Home : Screen("home","Home", Icons.Sharp.Home)
    object Categories : Screen("categories","Categories", Icons.AutoMirrored.Filled.ManageSearch)
    object Deals : Screen("deals","Deals",Icons.Outlined.AccessTime)
    object Lists: Screen("personalLists","Lists",Icons.Outlined.FavoriteBorder)
    object Account : Screen("account","Profile",Icons.Outlined.Person)
    object ProductDetails : Screen("products/{itemId}/{categoryName}","Details",Icons.Sharp.Info) {
        fun createRoute(itemId: Int, categoryName: String) = "products/$itemId/$categoryName"
    }
    object CategoryDetails : Screen("category/{categoryName}","Category Details",Icons.Sharp.Info) {
        fun createRoute(categoryName: String) = "category/$categoryName"
    }
}

