package com.gabriel.dailyhealthapp.presenter.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrainingEntity(
    val id: String,
    val name: String,
    val description: String,
    @DrawableRes val image: Int
): Parcelable


