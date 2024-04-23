package com.gabriel.dailyhealthapp.presenter.model

import com.gabriel.dailyhealthapp.R

data class Exercise(
    val items: List<ExerciseEntity> = listOf(
        ExerciseEntity(
            title = "Saltar à Corda",
            description = "00:20",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Abdominais",
            description = "x16",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Abdominal Russo",
            description = "x20",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Montanha",
            description = "x16",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Toque de Calcanhar",
            description = "x20",
            image = R.drawable.ic_exercise
        ),ExerciseEntity(
            title = "Elevação de Pernas",
            description = "x16",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Prancha",
            description = "00:20",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Abdominais",
            description = "x12",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Abdominal Russo",
            description = "x32",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Montanha",
            description = "x12",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Toque de Calcanhar",
            description = "x20",
            image = R.drawable.ic_exercise
        ),ExerciseEntity(
            title = "Elevação de Pernas",
            description = "x14",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Prancha",
            description = "00:30",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Alongamento Cobra",
            description = "00:30",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Alongamento de Coluna lombar",
            description = "00:30",
            image = R.drawable.ic_exercise
        ),
        ExerciseEntity(
            title = "Alongamento de Coluna lombar lado direito",
            description = "00:30",
            image = R.drawable.ic_exercise
        ),
    )
)
