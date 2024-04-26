package com.gabriel.dailyhealthapp.data.model

import com.google.firebase.database.FirebaseDatabase

data class TrainingData(
    var id: String = "",
    var name: String = "",
    var date: Long = 0,
    var description: String = ""
){
    init {
        this.id = FirebaseDatabase.getInstance().reference.push().key ?: ""
    }
}
