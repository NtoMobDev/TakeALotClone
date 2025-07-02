package com.example.takeALot.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.takeALot.presentation.navigation.BottomNav

@Composable
fun AccountPage(navController: NavController){
    Scaffold(topBar = { AppTopBar("Account")},bottomBar = { BottomNav(navController = navController)}) {
        innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Account Page")
        }

    }
}
