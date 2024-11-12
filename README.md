# KMP-Carousel-Slider
KMP Carousel Slider: Kotlin Compose Multiplatform

# KMP Carousel Slider with image and text - Compose Multiplatform

## [ANDROID, iOS, Desktop]

## How to use:

### Add below libraries:

android: 

`implementation("io.ktor:ktor-client-okhttp:3.0.0")`

iOS:
`implementation("io.ktor:ktor-client-darwin:3.0.0")`

Desktop:
`implementation("io.ktor:ktor-client-java:3.0.0")`

Common:
`implementation("io.coil-kt.coil3:coil-compose:3.0.0")
implementation("io.coil-kt.coil3:coil-network-ktor3:3.0.0")
implementation("io.ktor:ktor-client-core:3.0.0")`


Now find the MyCarousel.kt file in the commonMain package. 
Just copy and paste this file into your project.
Customise it if necessary or just use it with defaults.

### Use it like below:

Initialise data for slider:

`val sliderItems by remember {
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
}`

Place the slider in your page:

`MyCarousel(
    banners = sliderItems,
    slidePause = 3000,
    height = 150.dp,
    cornerRadius = 8.dp,
    horizontalItemPadding = 16.dp,
    pageSpace = 8.dp,
    activeIndicatorColor = Color.LightGray,
    inactiveIndicatorColor = Color.DarkGray,
    isCenterCropImage = true
)`

![Android Screenshot](http://url/to/img.png)
![iOS Screenshot](http://url/to/img.png)
![Desktop Screenshot](http://url/to/img.png)



All done ✅
