package com.l1max.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.l1max.app.ui.theme.L1MAXTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            L1MAXTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen(
                        onSplashComplete = {
                            // Navigate to carousel screen
                            val intent = Intent(this, CarouselActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onSplashComplete: () -> Unit = {}) {
    // Configuración parametrizable de la duración de la animación
    val animationDurationSeconds = 5
    
    // Composición de Lottie
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animacion))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        speed = 1f / animationDurationSeconds // Ajusta la velocidad para que dure 5 segundos
    )
    
    // Auto-navigate after 5 seconds
    LaunchedEffect(Unit) {
        delay(5000) // 5 seconds
        onSplashComplete()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1c0105)), // Fondo oscuro rojizo similar a la imagen
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Animación Lottie del gato
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.size(200.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Texto L1MAX
            Text(
                text = "L1MAX",
                color = Color.Red,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    L1MAXTheme {
        SplashScreen()
    }
}