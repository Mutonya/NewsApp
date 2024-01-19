package com.example.maestro.presentation.search

sealed class SearchEvents {

    data class UpdateSeachQuerry(val searchQuery:String):SearchEvents()

    object SearchNews:SearchEvents()
}