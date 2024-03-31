package com.example.typewritercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.typewritercompose.ui.theme.TypeWriterComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypeWriterComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onSurface
                ) {
                    TypeWriterAnimation(
                        text = "Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n" +
                                "\n" +
                                "In this tutorial, you'll build a simple UI component with declarative functions. You won't be editing any XML layouts or using the Layout Editor. Instead, you will call composable functions to define what elements you want, and the Compose compiler will do the rest"
                    )
                }
            }
        }
    }
}

@Composable
fun TypeWriterAnimation(text: String) {

    var textString by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = Unit) {
        for (i in text.indices) {
            textString = text.substring(0, i + 1)
            delay(100)
        }
    }

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), text = textString, fontSize = 24.sp, color = Color.Black
    )

}
