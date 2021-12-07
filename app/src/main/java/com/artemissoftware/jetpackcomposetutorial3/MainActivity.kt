package com.artemissoftware.jetpackcomposetutorial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.jetpackcomposetutorial3.ui.jettip.JetTip
import com.artemissoftware.jetpackcomposetutorial3.ui.moneytap.MoneyTap
import com.artemissoftware.jetpackcomposetutorial3.ui.theme.JetPackComposeTutorial3Theme
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.navigation.MovieNavigation

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTutorial3Theme {
                //MoneyTap()
                //JetTip()
                MovieNavigation()
            }
        }
    }
}


@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeTutorial3Theme {
        //MoneyTap()
        JetTip()
    }
}