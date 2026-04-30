package com.example.loging1.ui.screen

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loging1.ui.theme.BluePrimary
import com.example.loging1.ui.theme.BlueSecondary
import com.example.loging1.ui.theme.White
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    onNavigateNext: () -> Unit
) {
    val scale = remember { Animatable(0.5f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {

        // Animación de entrada
        launch {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(1000)
            )
        }

        launch {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(1200)
            )
        }

        // Espera tipo splash
        delay(2000)

        onNavigateNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(BluePrimary, BlueSecondary)
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .scale(scale.value)
                    .alpha(alpha.value)
                    .clip(CircleShape)
                    .background(White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "UAM",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = BluePrimary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Universidad Americana",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = White,
                modifier = Modifier.alpha(alpha.value)
            )

            Spacer(modifier = Modifier.height(40.dp))

            CircularProgressIndicator(
                color = White,
                modifier = Modifier.alpha(alpha.value)
            )
        }
    }
}