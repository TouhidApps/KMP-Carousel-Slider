package com.touhidapps.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.coroutines.delay

data class CarouselItemModel(
    val imageUrl: String,
    val contentDescription: String
)

@Composable
fun MyCarousel(
    banners: List<CarouselItemModel>,
    modifier: Modifier = Modifier,
    slidePause: Int,
    height: Dp = 150.dp,
    cornerRadius: Dp = 8.dp,
    horizontalItemPadding: Dp = 16.dp,
    pageSpace: Dp = 8.dp,
    activeIndicatorColor: Color = Color.LightGray,
    inactiveIndicatorColor: Color = Color.DarkGray,
    isCenterCropImage: Boolean = false
) {

    val pagerState = rememberPagerState(pageCount = {
        banners.size
    })

    LaunchedEffect(Unit) {
        while (true) {
            delay(slidePause.toLong())
            val pageToScroll = if (pagerState.currentPage == banners.size - 1) {
                0
            } else {
                pagerState.currentPage + 1
            }
            pagerState.animateScrollToPage(pageToScroll)
        }
    }

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier.height(height)
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = horizontalItemPadding),
            pageSpacing = pageSpace,
            verticalAlignment = Alignment.Top,
        ) { page ->
            BannerWidget(
                imageUrl = banners[page].imageUrl,
                contentDescription = banners[page].contentDescription,
                cornerRadius = cornerRadius,
                isCenterCropImage = isCenterCropImage,
                height = height
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) activeIndicatorColor else inactiveIndicatorColor
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }

}


@Composable
fun BannerWidget(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 8.dp,
    isCenterCropImage: Boolean = false,
    height: Dp
) {
    Box {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            contentScale = if (isCenterCropImage) ContentScale.Crop else ContentScale.Fit,
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .clip(RoundedCornerShape(cornerRadius))
        )

        Text(
            text = contentDescription,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(x = 2F, y = 2F),
                    blurRadius = 2F
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(height/2)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(bottomStart = cornerRadius, bottomEnd = cornerRadius))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.7F), Color.Transparent
                        ),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(0f,0f)
                    )
                )
                .padding(8.dp)
        )
    }

}

