package com.magednan.mortyapp.utils


sealed class Resource<out T>{

    object Loading: Resource<Nothing>()
    data class Error(val errorMessage: String?): Resource<Nothing>()
    data class Success<T>(var data: T): Resource<T>()

    companion object {
        fun <T> loading(): Resource<T> = Loading

        fun <T> error(errorMessage: String): Resource<T> = Error(errorMessage)

        fun <T> success(data: T): Success<T> = Success(data)
    }
}