package com.example.maestro.utils

abstract class Resource <out R>{

    data class Success<out R>(val result:R): Resource<R>()

    data class Failure(
        val isNetworkError:Boolean,
        val errorCode:Int?,
        val errorbody: String?
    ) : Resource<Nothing>()

     object Loading: Resource<Nothing>()

}