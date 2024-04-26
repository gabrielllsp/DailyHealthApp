package com.gabriel.dailyhealthapp.presenter.exercise_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gabriel.dailyhealthapp.data.model.TrainingData
import com.gabriel.dailyhealthapp.domain.training.SaveTrainingUseCase
import com.gabriel.dailyhealthapp.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ChestViewModel @Inject constructor(
    private val saveTrainingUseCase: SaveTrainingUseCase
): ViewModel() {

    fun saveTraining(training: TrainingData) = liveData(Dispatchers.IO){
        try {
            emit(StateView.Loading())

            val result = saveTrainingUseCase.invoke(training)

            emit(StateView.Sucess(result))
        }catch (ex: Exception){
            emit(StateView.Error(ex.message))
        }
    }
}