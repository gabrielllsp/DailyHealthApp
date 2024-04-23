package com.gabriel.dailyhealthapp.data.repository.profile

import com.gabriel.dailyhealthapp.data.model.User

interface ProfileDataSource {

    suspend fun saveProfile(user: User)
}