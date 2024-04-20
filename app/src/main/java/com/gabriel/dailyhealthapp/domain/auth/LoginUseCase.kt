package com.gabriel.dailyhealthapp.domain.auth

import com.gabriel.dailyhealthapp.data.repository.auth.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
) {
    suspend operator fun invoke(email: String, password: String){
        return authFirebaseDataSourceImpl.login(email, password)
    }
}