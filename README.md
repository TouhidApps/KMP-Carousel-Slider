# KMP Carousel Slider with image and text - Kotlin Compose Multiplatform

## [ANDROID, iOS, Desktop]

## How to use:

### Add below libraries:

Common:
```
commonMain.dependencies {
    ...
    implementation("io.coil-kt.coil3:coil-compose:3.0.0")
    implementation("io.coil-kt.coil3:coil-network-ktor3:3.0.0")
    implementation("io.ktor:ktor-client-core:3.0.0")
}
```

android: 
```
androidMain.dependencies {
    ...
    implementation("io.ktor:ktor-client-okhttp:3.0.0")
}
```

iOS:
```
iosMain.dependencies {
    implementation("io.ktor:ktor-client-darwin:3.0.0")
}
appleMain.dependencies {
    implementation("io.ktor:ktor-client-darwin:3.0.0")
}
```

Desktop:
```
desktopMain.dependencies {
    ...
    implementation("io.ktor:ktor-client-java:3.0.0")
}
```

Now find the MyCarousel.kt file in the commonMain package. 
Just copy and paste this file into your project.
Customise it if necessary or just use it with defaults.

File Link: [MyCarousel.kt](https://github.com/TouhidApps/KMP-Carousel-Slider/blob/main/composeApp/src/commonMain/kotlin/com/touhidapps/carousel/MyCarousel.kt)

### Use it like below:

Initialise data for slider:
```
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
```

Place the slider in your page:
```
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
```

![Android Screenshot](https://raw.githubusercontent.com/TouhidApps/KMP-Carousel-Slider/refs/heads/main/screenshots/slider_android.png)
![iOS Screenshot](https://raw.githubusercontent.com/TouhidApps/KMP-Carousel-Slider/refs/heads/main/screenshots/slider_ios.png)
![Desktop Screenshot](https://raw.githubusercontent.com/TouhidApps/KMP-Carousel-Slider/refs/heads/main/screenshots/slider_desktop.png)



All done ✅
