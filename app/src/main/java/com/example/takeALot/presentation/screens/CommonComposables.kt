package com.example.takeALot.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.takeALot.ui.theme.PrimaryBlue

@Composable
fun ErrorScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message, color = PrimaryBlue)
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = PrimaryBlue)
    }
}

@Composable
fun SuccessScreen(message: String) {


}
@Composable
fun BoxBadge(data:String,badgeColor:Color){
    Box(modifier = Modifier
        .size(40.dp)
        .clip(RoundedCornerShape(
                topStart = 4.dp,
                topEnd = 4.dp,
                bottomEnd = 4.dp,
                bottomStart = 4.dp))
        .background(color = badgeColor), contentAlignment = Alignment.Center){
        Column (horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center){
            Text(text = data,color = Color.White, fontWeight = FontWeight.Bold)
           }


    }
}
