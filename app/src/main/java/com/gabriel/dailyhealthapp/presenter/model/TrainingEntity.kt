package com.gabriel.dailyhealthapp.presenter.model

import androidx.annotation.DrawableRes

data class TrainingEntity(
    val name: String,
    val description: String,
    @DrawableRes val image: Int
)


