package com.example.loging1.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailView(
    userId : Int,
    onBack:()->Unit
){
    Column {
        Text("Detalle del usuario: ${userId}")
    }
    Button(onBack){
        Text("Regresar")
    }
}