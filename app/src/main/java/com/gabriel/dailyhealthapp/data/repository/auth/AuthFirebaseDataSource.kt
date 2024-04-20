package com.gabriel.dailyhealthapp.data.repository.auth

import com.gabriel.dailyhealthapp.data.model.User

interface AuthFirebaseDataSource {

    suspend fun login(
        email: String,
        password: String
    )

    suspend fun register(
        user: User
    ): User

    suspend fun recover(
        email: String
    )
}