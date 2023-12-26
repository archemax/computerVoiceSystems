package com.example.computervoicesystems.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.computervoicesystems.R

@Composable
fun CategoryDivider() {
    Divider(
        color = Color.LightGray, thickness = 2.dp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun ListHeader() {
    Text(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp

            )
            .background(Color.White)
            .fillMaxWidth(),
        text = "Movies",
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold


        )
    )
}

@Composable
fun ArrowBack() {
    Row(

        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_back_24),
            contentDescription = "arrowBack"
        )
        Text(
            text = "Movies",
            style = TextStyle(
                fontSize = 18.sp,
            )
        )
    }

}

