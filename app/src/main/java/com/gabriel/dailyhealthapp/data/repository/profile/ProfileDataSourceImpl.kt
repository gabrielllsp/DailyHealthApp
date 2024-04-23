package com.gabriel.dailyhealthapp.data.repository.profile

import com.gabriel.dailyhealthapp.data.model.User
import com.gabriel.dailyhealthapp.util.FirebaseHelper
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class ProfileDataSourceImpl @Inject constructor(
    database: FirebaseDatabase
) : ProfileDataSource {

    private val profileReference = database.reference
        .child("profile")
        .child(FirebaseHelper.getUserId())

    override suspend fun saveProfile(user: User) {
        return suspendCoroutine { continuation ->
            profileReference.setValue(user).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    continuation.resumeWith(Result.success(Unit))
                } else {
                    task.exception?.let {
                        continuation.resumeWith(Result.failure(it))
                    }
                }

            }
        }
    }
}