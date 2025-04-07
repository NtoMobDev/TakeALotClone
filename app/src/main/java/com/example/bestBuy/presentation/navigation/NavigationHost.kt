package com.example.bestBuy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(){
    //You're actually getting a NavHostController, but you usually reference it as the more generic NavController.
    val navController:NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        //composable is a navgraphbuilder extension function
        composable(Screen.Home.route){}
        composable(Screen.Cart.route){}
        composable(Screen.Profile.route){}
        composable(Screen.Details.route){}


    }


}