package com.artemissoftware.jetpackcomposetutorial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.jetpackcomposetutorial3.ui.jettip.JetTip
import com.artemissoftware.jetpackcomposetutorial3.ui.moneytap.MoneyTap
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.screen.NotesScreen
import com.artemissoftware.jetpackcomposetutorial3.ui.theme.JetPackComposeTutorial3Theme
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.ToTheMovies
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.navigation.MovieNavigation

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTutorial3Theme {
                //MoneyTap()
                //JetTip()
                //ToTheMovies()
                NotesScreen(notes = emptyList(), onAddNote = {}, onRemoveNote = {})
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