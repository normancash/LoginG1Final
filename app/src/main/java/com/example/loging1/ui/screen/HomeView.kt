package com.example.loging1.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeView(onNavigationToDetail:(Int)->Unit){
    Column{
        Button({onNavigationToDetail(1)})
        {
            Text("Ir al detalle")
        }
    }
}