package com.gabriel.dailyhealthapp.domain.auth

import com.gabriel.dailyhealthapp.data.model.User
import com.gabriel.dailyhealthapp.data.repository.auth.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
) {
    suspend operator fun invoke(user: User): User{
        return authFirebaseDataSourceImpl.register(user)
    }
}