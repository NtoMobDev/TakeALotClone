package com.example.takeALot.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BottomNav(navController: NavController){
    val screens = listOf(Screen.Home,Screen.Categories,Screen.Deals,Screen.Lists,Screen.Account)

   val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(modifier = Modifier.fillMaxWidth(), containerColor = Color(0xFFF2F2F7),
        contentColor = Color(0xFFE3E3E8), tonalElevation = 20.dp) {
        screens.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(selectedIconColor = Color(0xFF0076D6),
                    unselectedIconColor = Color(0xFFA1A1A5), selectedTextColor = Color(0xFF0076D6),
                    unselectedTextColor = Color(0xFFA1A1A5),indicatorColor = Color(0xFFF2F2F7))
            )
        }

    }

}