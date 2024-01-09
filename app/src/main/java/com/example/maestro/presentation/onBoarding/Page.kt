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
        title = "Stay Informed, Stay Connected",
        description = "Welcome to Maestro, your go-to source for breaking news, insightful analysis, and personalized content.",
        image = R.drawable.maestro

    ),
    Page(
        title = "Tailored Just for You",
        description = "Customize your news feed to match your interests. Whether it's politics, technology, or entertainment, we've got you covered.",
        image = R.drawable.maestro

    ),
    Page(
        title = "Be the First to Know",
        description = "Receive instant notifications for breaking news and updates. Stay ahead with real-time alerts delivered to your device.",
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