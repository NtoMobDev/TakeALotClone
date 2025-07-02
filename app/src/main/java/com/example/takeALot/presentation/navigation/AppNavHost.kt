package com.example.takeALot.presentation.navigation

import androidx.compose.runtime.Composable
// import androidx.hilt.navigation.compose.hiltViewModel // Keep if ViewModels are used in screens
import androidx.navigation.NavHostController
import androidx.navigation.NavType
// import androidx.navigation.NavType // No longer directly needed here
import androidx.navigation.compose.NavHost // No longer directly needed here
import androidx.navigation.compose.composable
// import androidx.navigation.compose.composable // No longer directly needed here
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.takeALot.presentation.screens.AccountPage
// import androidx.navigation.navArgument // No longer directly needed here
import com.example.takeALot.presentation.screens.CategoryDetailScreen
import com.example.takeALot.presentation.screens.HomeScreen
import com.example.takeALot.presentation.screens.ProductDetailScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {


    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Categories.route) { /* Your CartScreen(navController) */ }
        composable(Screen.Deals.route) {  }
        composable(Screen.Lists.route) { /* Your SearchScreen(navController) */ }
        composable(Screen.Account.route) { AccountPage(navController) }
        composable(
            route = Screen.ProductDetails.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType },
                navArgument("categoryName") { type = NavType.StringType })

        ) {
            // It's good practice for screens to manage their own ViewModels if needed
            // Example: val viewModel: ProductDetailViewModel = hiltViewModel()
            ProductDetailScreen(navController)
        }
        composable(
            route = Screen.CategoryDetails.route,
            arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
        ) {
            // Example: val viewModel: CategoryDetailViewModel = hiltViewModel()
            CategoryDetailScreen(navController)
        }
        // Add other destinations...
    }
}

