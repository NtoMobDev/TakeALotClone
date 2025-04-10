package com.example.bestBuy.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bestBuy.presentation.screens.HomeScreen

@Composable
fun AppNavHost(navController:NavHostController = rememberNavController()){
    //You're actually getting a NavHostController, but you usually reference it as the more generic NavController.
Scaffold(
    bottomBar = { BottomNav(navController)}
    ) { padding ->
    NavHost(navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(padding)
    ) {
        composable(Screen.Home.route){ HomeScreen(navController)} //composable is a navgraphbuilder extension function
        composable(Screen.Cart.route){}
        composable(Screen.Profile.route){}
        composable(Screen.Search.route){}

    }

}

}
