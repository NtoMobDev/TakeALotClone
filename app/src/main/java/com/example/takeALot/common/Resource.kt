package com.example.takeALot.common

sealed class Resource<T>(val data:  T? = null, val message : String?=null){
    class Success<T> (data: T?) : Resource<T>(data)
    class Loading<T>(data: T?= null) : Resource<T>(data)
    class Error<T>(data: T? = null, message: String?) : Resource<T>(data,message)
}