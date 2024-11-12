package com.touhidapps.carousel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {


        val sliderItems by remember {
            mutableStateOf(
                listOf(
                    CarouselItemModel(
                        imageUrl = "https://placehold.co/600x200/jpg",
                        contentDescription = "Nice weather"
                    ),
                    CarouselItemModel(
                        imageUrl = "https://placehold.co/800x250/png",
                        contentDescription = "Good morning"
                    ),
                    CarouselItemModel(
                        imageUrl = "https://placehold.co/900x280/jpg",
                        contentDescription = "Its okay"
                    )
                )
            )
        }


        Column {
            Spacer(
                modifier = Modifier.height(20.dp)
            )


            MyCarousel(
                banners = sliderItems,
                slidePause = 3000,
                height = 150.dp,
                cornerRadius = 8.dp,
                horizontalItemPadding = 16.dp,
                pageSpace = 8.dp,
                activeIndicatorColor = Color.LightGray,
                inactiveIndicatorColor = Color.DarkGray,
                isCenterCropImage = true
            )


        }

    }
}