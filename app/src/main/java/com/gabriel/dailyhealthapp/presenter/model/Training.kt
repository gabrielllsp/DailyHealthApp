package com.gabriel.dailyhealthapp.presenter.model

import com.gabriel.dailyhealthapp.R

data class Training(
    val items: List<TrainingEntity> = listOf(
        TrainingEntity(
            id = "0",
            name = "TREINO DE ABDÔMEM",
            "20 MIN - 16 EXERCÍCIOS",
            image = R.drawable.abdominal
        ),
        TrainingEntity(
            id = "1",
            name = "TREINO DE BRAÇO",
            "17 MIN - 19 EXERCÍCIOS",
            image = R.drawable.arm
        ),
        TrainingEntity(
            id = "2",
            name = "TREINO DE COSTAS E OMBROS",
            "17 MIN - 17 EXERCÍCIOS",
            image = R.drawable.coast
        ),
        TrainingEntity(
            id = "3",
            name = "TREINO DE PEITO",
            "9 MIN - 11 EXERCÍCIOS",
            image = R.drawable.chest
        ),
        TrainingEntity(
            id = "4",
            name = "TREINO DE PERNAS",
            "26 MIN - 23 EXERCÍCIOS",
            image = R.drawable.leg

        ),
    )
)