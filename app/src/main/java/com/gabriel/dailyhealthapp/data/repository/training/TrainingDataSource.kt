package com.gabriel.dailyhealthapp.data.repository.training

import com.gabriel.dailyhealthapp.data.model.TrainingData

interface TrainingDataSource {

    suspend fun saveTraining(training: TrainingData): TrainingData
}