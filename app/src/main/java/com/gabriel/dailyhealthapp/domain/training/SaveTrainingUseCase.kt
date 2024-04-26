package com.gabriel.dailyhealthapp.domain.training

import com.gabriel.dailyhealthapp.data.model.TrainingData
import com.gabriel.dailyhealthapp.data.repository.training.TrainingDataSourceImpl
import javax.inject.Inject

class SaveTrainingUseCase @Inject constructor(
    private val trainingDataSourceImpl: TrainingDataSourceImpl
){
    suspend operator fun invoke(training: TrainingData): TrainingData{
        return trainingDataSourceImpl.saveTraining(training)
    }
}