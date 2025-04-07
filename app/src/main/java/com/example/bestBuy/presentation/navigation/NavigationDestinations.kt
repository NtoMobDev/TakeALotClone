package com.example.bestBuy.presentation.navigation

//define destinations
sealed class Screen(val route:String){
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object Details : Screen("details/{itemId}") {
        fun createRoute(itemId: String) = "details/$itemId"
    }
}