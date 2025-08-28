package com.l1max.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.l1max.app.ui.theme.L1MAXTheme
import kotlinx.coroutines.delay

class CarouselActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            L1MAXTheme {
                CarouselScreen(
                    onContinueClick = {
                        // Navigate to next screen
                        // TODO: Add navigation to main app screen
                    },
                    onEntelClick = {
                        // Handle Entel button click
                        // TODO: Add Entel specific functionality
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CarouselScreen(
    onContinueClick: () -> Unit,
    onEntelClick: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    
    // Auto-scroll effect
    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000) // Change slide every 3 seconds
            val nextPage = (pagerState.currentPage + 1) % 2
            pagerState.animateScrollToPage(nextPage)
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D1B1B)), // Dark reddish background
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // L1MAX Logo at top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Star icon
            Text(
                text = "✦",
                color = Color(0xFFFF4444),
                fontSize = 24.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            // L1MAX text
            Text(
                text = "L1MAX",
                color = Color(0xFFFF4444),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        
        Spacer(modifier = Modifier.height(40.dp))
        
        // Carousel
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> CarouselPage1()
                    1 -> CarouselPage2()
                }
            }
            
            // Page indicators
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(2) { index ->
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = if (index == pagerState.currentPage) 
                                    Color.White else Color.Gray,
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(40.dp))
        
        // Continue button
        Button(
            onClick = onContinueClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF4444)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "CONTINUAR",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        
        Spacer(modifier = Modifier.height(20.dp))
        
        // Entel button
        Button(
            onClick = onEntelClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0066CC)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // Entel logo placeholder
                Text(
                    text = "e",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(
                            Color.White,
                            RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "entel",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Soy Entel Postpago",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun CarouselPage1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Phone image
        Image(
            painter = painterResource(id = R.drawable.movil_l1p_1),
            contentDescription = "Phone with L1MAX app",
            modifier = Modifier
                .size(200.dp, 300.dp),
            contentScale = ContentScale.Fit
        )
        
        Spacer(modifier = Modifier.height(30.dp))
        
        // Text
        Text(
            text = "Si eres Entel Postpago\nrecuerda conectarte desde\nred móvil",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )
    }
}

@Composable
fun CarouselPage2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Players image
        Image(
            painter = painterResource(id = R.drawable.l1maxjugadores3),
            contentDescription = "Football players",
            modifier = Modifier
                .size(300.dp, 200.dp),
            contentScale = ContentScale.Fit
        )
        
        Spacer(modifier = Modifier.height(30.dp))
        
        // Text
        Text(
            text = "Mira la Liga Te Apuesto\nen vivo y más",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )
    }
}