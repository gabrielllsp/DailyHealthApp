package com.gabriel.dailyhealthapp.data.repository.auth

import com.gabriel.dailyhealthapp.data.model.User

interface AuthFirebaseDataSource {

    suspend fun login(
        email: String,
        password: String
    )

    suspend fun register(
        name: String,
        email: String,
        password: String
    ): User

    suspend fun recover(
        email: String
    )
}