package com.gabriel.dailyhealthapp.presenter.model

import com.gabriel.dailyhealthapp.R

data class Training(
    val items: List<TrainingEntity> = listOf(
        TrainingEntity(
            name = "TREINO DE ABDÔMEM",
            "20 MIN - 16 EXERCÍCIOS",
            image = R.drawable.abdominal
        ),
        TrainingEntity(
            name = "TREINO DE BRAÇO",
            "17 MIN - 19 EXERCÍCIOS",
            image = R.drawable.arm
        ),
        TrainingEntity(
            name = "TREINO DE COSTAS E OMBROS",
            "17 MIN - 17 EXERCÍCIOS",
            image = R.drawable.coast
        ),
        TrainingEntity(
            name = "TREINO DE PEITO",
            "9 MIN - 11 EXERCÍCIOS",
            image = R.drawable.chest
        ),
        TrainingEntity(
            name = "TREINO DE PERNAS",
            "26 MIN - 23 EXERCÍCIOS",
            image = R.drawable.leg

        ),
    )
)