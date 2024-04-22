package com.gabriel.dailyhealthapp.util

sealed class StateView<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : StateView<T>(data = null, message = null)

    class Error<T>(message: String?) :
        StateView<T>(message = message)

    class Sucess<T>(data: T, message: String? = null) : StateView<T>(data = data, message = message)
}