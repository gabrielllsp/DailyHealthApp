package com.gabriel.dailyhealthapp.domain.profile

import com.gabriel.dailyhealthapp.data.model.User
import com.gabriel.dailyhealthapp.data.repository.profile.ProfileDataSourceImpl
import javax.inject.Inject

class SaveProfileUseCase @Inject constructor(
    private val profileDataSourceImpl: ProfileDataSourceImpl
){
    suspend fun invoke(user: User){
        return profileDataSourceImpl.saveProfile(user)
    }
}