package com.gabriel.dailyhealthapp.presenter.model

import androidx.annotation.DrawableRes

data class ExerciseEntity(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)