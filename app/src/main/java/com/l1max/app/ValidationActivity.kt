package com.l1max.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.l1max.app.ui.theme.L1MAXTheme
import kotlinx.coroutines.delay

class ValidationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            L1MAXTheme {
                ValidationScreen()
            }
        }
    }
}

@Composable
fun ValidationScreen() {
    val context = LocalContext.current
    
    // Navigate to HomeActivity after 3 seconds
    LaunchedEffect(Unit) {
        delay(3000)
        // val intent = Intent(context, HomeActivity::class.java)
        // context.startActivity(intent)
        // TODO: HomeActivity was removed
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1c0105))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo L1MAX
            Image(
                painter = painterResource(id = R.drawable.logol1max),
                contentDescription = "L1MAX Logo",
                modifier = Modifier
                    .width(120.dp)
                    .height(60.dp),
                contentScale = ContentScale.Fit
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Texto de validación
            Text(
                text = "Validando los datos...",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}