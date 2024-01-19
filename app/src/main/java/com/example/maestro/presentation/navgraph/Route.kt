package com.example.maestro.presentation.navgraph

sealed class Route(

    val route:String
){
    object OnBoardingScreen:Route(route = "onBoardingScreen")
    object HomeScreen:Route(route = "homeScreen")

    object SearchScreen:Route(route = "SearchScreen")

    object BookMarkScreen:Route(route = "bookMarkScreen")

    object DetailScreen:Route(route = "detailScreen")

    object NewsNavigation:Route(route = "newsNavigation")

    object AppStartNavigation:Route(route = "appStartNavigation")
    object NewsNavigationScreen:Route(route = "newsNavigationScreen")



}
