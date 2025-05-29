package com.example.bestBuy.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bestBuy.presentation.screens.DetailedScreenTopBar
import com.example.bestBuy.presentation.screens.HomeScreen
import com.example.bestBuy.presentation.screens.ProductDetailScreen

@Composable
fun AppNavHost(navController:NavHostController = rememberNavController()){
    //You're actually getting a NavHostController, but you usually reference it as the more generic NavController.
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    // Get the current route
    val currentRoute = navBackStackEntry?.destination?.route
Scaffold(

        bottomBar = {if (currentRoute != Screen.ProductDetails.route) BottomNav(navController,currentRoute)}


    ) { padding ->
    NavHost(navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(padding)
    ) {
        composable(Screen.Home.route){ HomeScreen(navController)} //composable is a navgraphbuilder extension function
        composable(Screen.Cart.route){}
        composable(Screen.Profile.route){}
        composable(Screen.Search.route){}
        composable(
            route = Screen.ProductDetails.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) {
            ProductDetailScreen(navController)
        }



    }

}

}

private fun shouldShowBottomBar(currentRoute: String?): Boolean {
    return when (currentRoute) {
        Screen.ProductDetails.route -> false // Hide on ProductDetails
        // Add other routes where you want to hide the bottom bar
        // "another_screen_route" -> false
        else -> true // Show on all other screens
    }
}

private fun showDetailedScreenTopBar(currentRoute: String?): Boolean {
    return when (currentRoute) {
        Screen.ProductDetails.route -> true // Hide on ProductDetails
        // Add other routes where you want to hide the bottom bar
        // "another_screen_route" -> false
        else -> false // Show on all other screens
    }
}