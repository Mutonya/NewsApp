package com.example.maestro.presentation.onBoarding

import androidx.annotation.DrawableRes
import com.example.maestro.R

data class Page (

    val title:String,
    val description:String,
    @DrawableRes val image:Int
)

val Pages = listOf(
    Page(
        title = "Welcome to",
        description = "A simplified checkin & checkout system for all visitors at various checkpoints in a premises",
        image = R.drawable.maestro

    ),
    Page(
        title = "Welcome to",
        description = "All laptops and computer macinery that a visitor might be having should be scanned for serial code",
        image = R.drawable.maestro

    ),
    Page(
        title = "Welcome to",
        description = "A centralised data point to enable swift tracking of all visitors in a premises at a particular time.",
        image = R.drawable.maestro

    ),
    Page(
        title = "Explore the World of News",
        description = "Dive into a diverse range of topics, from global events to niche interests. Discover new perspectives with our curated content.",
        image = R.drawable.maestro

    ),
    Page(
        title = "Save What Matters",
        description = "Bookmark articles and stories for later reading. Your personalized reading list is just a tap away, making it easy to catch up on your schedule.",
        image = R.drawable.maestro

    )


)