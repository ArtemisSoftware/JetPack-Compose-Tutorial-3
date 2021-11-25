package com.artemissoftware.jetpackcomposetutorial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.jetpackcomposetutorial3.ui.theme.JetPackComposeTutorial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTutorial3Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFF546E7A)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "$100",
                style = TextStyle(color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold))

            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle()
        }


    }


}

@Preview(showBackground = true)
@Composable
fun CreateCircle() {

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {

            }
        ,
        shape = CircleShape,
        elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeTutorial3Theme {
        MyApp()
    }
}