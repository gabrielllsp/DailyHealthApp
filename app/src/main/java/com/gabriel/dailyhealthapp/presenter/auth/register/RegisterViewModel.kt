package com.gabriel.dailyhealthapp.presenter.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gabriel.dailyhealthapp.data.model.User
import com.gabriel.dailyhealthapp.domain.auth.RegisterUseCase
import com.gabriel.dailyhealthapp.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val resisterUseCase: RegisterUseCase
): ViewModel() {
    fun register(user: User) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            resisterUseCase.invoke(user)
            emit(StateView.Sucess(user))
        } catch (ex: Exception) {
            emit(StateView.Error(ex.message))
        }
    }
}