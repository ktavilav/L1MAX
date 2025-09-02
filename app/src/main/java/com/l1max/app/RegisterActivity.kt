package com.l1max.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.l1max.app.ui.theme.L1MAXTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            L1MAXTheme {
                RegisterScreen(
                    onBackClick = { finish() },
                    onRegisterClick = { 
                        val intent = Intent(this@RegisterActivity, ValidationActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onBackClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var repetirContrasena by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var showRepeatPassword by remember { mutableStateOf(false) }

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
            
            // Title
            Text(
                text = "Regístrate",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(40.dp))
            
            // Nombre field
            RegisterTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = "Nombre:",
                keyboardType = KeyboardType.Text
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Apellido field
            RegisterTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = "Apellido:",
                keyboardType = KeyboardType.Text
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Correo field
            RegisterTextField(
                value = correo,
                onValueChange = { correo = it },
                label = "Correo electrónico:",
                keyboardType = KeyboardType.Email
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Contraseña field
            RegisterPasswordField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = "Contraseña:",
                showPassword = showPassword,
                onTogglePasswordVisibility = { showPassword = !showPassword }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Repetir contraseña field
            RegisterPasswordField(
                value = repetirContrasena,
                onValueChange = { repetirContrasena = it },
                label = "Repetir contraseña:",
                showPassword = showRepeatPassword,
                onTogglePasswordVisibility = { showRepeatPassword = !showRepeatPassword }
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Register button
            Button(
                onClick = onRegisterClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF808080)
                )
            ) {
                Text(
                    text = "REGISTRAR",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Terms and conditions
            Text(
                text = "Al registrarte estás aceptando nuestro términos y condiciones de Políticas y privacidad",
                fontSize = 12.sp,
                color = Color(0xFFDC2626),
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType
) {
    Column {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color(0xFF999999),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color(0xFF666666),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    showPassword: Boolean,
    onTogglePasswordVisibility: () -> Unit
) {
    Column {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color(0xFF999999),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color(0xFF666666),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                TextButton(onClick = onTogglePasswordVisibility) {
                    Text(
                        text = if (showPassword) "👁️" else "👁️‍🗨️",
                        color = Color(0xFF999999),
                        fontSize = 16.sp
                    )
                }
            },
            singleLine = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    L1MAXTheme {
        RegisterScreen(
            onBackClick = {},
            onRegisterClick = {}
        )
    }
}