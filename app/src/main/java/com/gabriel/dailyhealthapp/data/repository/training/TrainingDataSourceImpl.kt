package com.gabriel.dailyhealthapp.data.repository.training

import com.gabriel.dailyhealthapp.data.model.TrainingData
import com.gabriel.dailyhealthapp.util.FirebaseHelper
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class TrainingDataSourceImpl @Inject constructor(
    database: FirebaseDatabase
) : TrainingDataSource {

    private val trainingReference = database.reference
        .child("training")
        .child(FirebaseHelper.getUserId())

    override suspend fun saveTraining(training: TrainingData): TrainingData {
        return suspendCoroutine { continuation ->
            trainingReference
                .setValue(training).addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        val dataReference = trainingReference
                            .child(training.id)
                            .child("date")
                        dataReference.setValue(ServerValue.TIMESTAMP)
                            .addOnCompleteListener { taskUpdate ->
                                if (taskUpdate.isSuccessful) {
                                    continuation.resumeWith(Result.success(training))
                                }else{
                                    taskUpdate.exception?.let {
                                        continuation.resumeWith(Result.failure(it))
                                    }
                                }
                            }
                    } else {
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }
                }
        }
    }
}