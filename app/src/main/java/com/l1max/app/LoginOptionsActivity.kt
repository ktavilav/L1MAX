package com.l1max.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.l1max.app.ui.theme.L1MAXTheme

class LoginOptionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            L1MAXTheme {
                LoginOptionsScreen(
                    onBackClick = { finish() },
                    onAppleClick = { /* TODO: Implement Apple login */ },
                    onGoogleClick = { /* TODO: Implement Google login */ },
                    onEmailClick = { /* TODO: Implement Email login */ },
                    onRegisterClick = { 
                        val intent = Intent(this@LoginOptionsActivity, RegisterActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginOptionsScreen(
    onBackClick: () -> Unit,
    onAppleClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onEmailClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A0A0A))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top bar with back button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            
            // L1MAX Logo
            Image(
                painter = painterResource(id = R.drawable.logol1max),
                contentDescription = "L1MAX Logo",
                modifier = Modifier
                    .width(120.dp)
                    .height(60.dp),
                contentScale = ContentScale.Fit
            )
            
            Spacer(modifier = Modifier.height(60.dp))
            
            // Title
            Text(
                text = "Vincula una opción\npara iniciar",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )
            
            Spacer(modifier = Modifier.height(60.dp))
            
            // Login options
            LoginOptionButton(
                text = "Vincular con Apple",
                painter = painterResource(id = R.drawable.apple),
                backgroundColor = Color.White,
                textColor = Color.Black,
                onClick = onAppleClick
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            LoginOptionButton(
                text = "Vincular con Google",
                painter = painterResource(id = R.drawable.google),
                backgroundColor = Color.White,
                textColor = Color.Black,
                onClick = onGoogleClick
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            LoginOptionButton(
                text = "VINCULAR CON CORREO ELECTRÓNICO",
                painter = painterResource(id = R.drawable.letter),
                backgroundColor = Color(0xFFDC2626),
                textColor = Color.White,
                onClick = onEmailClick
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Register section
            Text(
                text = "¿Aún no tienes cuenta?",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedButton(
                onClick = onRegisterClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    Color(0xFFDC2626)
                )
            ) {
                Text(
                    text = "REGÍSTRATE",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun LoginOptionButton(
    text: String,
    icon: String? = null,
    painter: androidx.compose.ui.graphics.painter.Painter? = null,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (painter != null) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            } else if (icon != null) {
                Text(
                    text = icon,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                fontSize = if (text.length > 20) 14.sp else 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginOptionsScreenPreview() {
    L1MAXTheme {
        LoginOptionsScreen(
            onBackClick = {},
            onAppleClick = {},
            onGoogleClick = {},
            onEmailClick = {},
            onRegisterClick = {}
        )
    }
}