package com.gabriel.dailyhealthapp.presenter.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gabriel.dailyhealthapp.domain.auth.LoginUseCase
import com.gabriel.dailyhealthapp.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
):ViewModel() {
    fun login(email: String, password: String) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            loginUseCase.invoke(email, password)
            emit(StateView.Sucess(null))
        } catch (ex: Exception) {
            emit(StateView.Error(ex.message))
        }
    }
}