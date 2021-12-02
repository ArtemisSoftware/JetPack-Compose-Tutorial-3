package com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ToTheMovies() {

    Surface(color = MaterialTheme.colors.background) {
        
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "To The Movies")
            }
        }) {
            
        }
        
    }
}
