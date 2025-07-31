package com.example.foodlink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodlink.ui.theme.FoodlinkTheme

// Define colors to match the design
val AppGreen = Color(0xFF63B546)
val TextWhite = Color.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodlinkTheme {
                // Set the status bar color to be transparent to achieve the edge-to-edge effect
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppGreen
                ) {
                    WelcomeScreen()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppGreen)
            .padding(horizontal = 32.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround // Distributes space evenly
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        WelcomeHeader()

        Spacer(modifier = Modifier.height(48.dp))

        AppLogo()

        Spacer(modifier = Modifier.weight(1f)) // Pushes content below it down

        LoginAndSocials()

        Spacer(modifier = Modifier.height(24.dp))

        CallCenterInfo()
    }
}

@Composable
fun WelcomeHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Selamat Datang di ",
            color = TextWhite,
            fontSize = 18.sp
        )
        Card(
            shape = RoundedCornerShape(50), // Fully rounded corners
            colors = CardDefaults.cardColors(containerColor = TextWhite)
        ) {
            Text(
                text = "SahabatPangan",
                color = AppGreen,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun AppLogo() {
    // IMPORTANT: Replace R.drawable.app_logo with your actual logo file in res/drawable
//    Image(
//        painter = painterResource(id = R.drawable.app_logo),
//        contentDescription = "App Logo",
//        modifier = Modifier
//            .fillMaxWidth(0.8f) // Takes 80% of the column width
//            .aspectRatio(1f) // Makes the image container a square
//    )
}

@Composable
fun LoginAndSocials() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp) // Space between children
    ) {
        Button(
            onClick = { /* TODO: Handle login click */ },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = TextWhite),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Masuk",
                color = AppGreen,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        SignUpText()

        Spacer(modifier = Modifier.height(8.dp))

//        SocialLoginIcons()
    }
}


@Composable
fun SignUpText() {
    // buildAnnotatedString allows mixing different styles in one Text composable
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = TextWhite, fontSize = 14.sp)) {
            append("Belum memiliki akun? ")
        }
        withStyle(style = SpanStyle(
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            fontSize = 14.sp
        )) {
            append("Daftar Akun")
        }
    }
    Text(text = annotatedString)
}

//@Composable
//fun SocialLoginIcons() {
//    Row(
//        horizontalArrangement = Arrangement.spacedBy(24.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // IMPORTANT: Replace with your actual icon files
//        SocialIcon(drawableId = R.drawable.ic_facebook, description = "Facebook Login")
//        SocialIcon(drawableId = R.drawable.ic_google, description = "Google Login")
//        SocialIcon(drawableId = R.drawable.ic_instagram, description = "Instagram Login")
//    }
//}

@Composable
fun SocialIcon(drawableId: Int, description: String) {
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = description,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape) // Makes the image circular
    )
}

@Composable
fun CallCenterInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Call Center SahabatPangan",
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call Icon",
                tint = TextWhite,
                modifier = Modifier.size(16.dp)
            )
            // The phone number in the image was invalid, using a placeholder.
            Text(
                text = "+62 123456789",
                color = TextWhite,
                fontSize = 14.sp
            )
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun WelcomeScreenPreview() {
    FoodlinkTheme {
        Surface(color = AppGreen) {
            // In a preview, you might not have real drawables.
            // For a functional preview, you can create placeholder composables
            // or ensure your drawable resources are available in the preview context.
            WelcomeScreen()
        }
    }
}