package com.artemissoftware.jetpackcomposetutorial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.jetpackcomposetutorial3.ui.jettip.JetTip
import com.artemissoftware.jetpackcomposetutorial3.ui.moneytap.MoneyTap
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.data.Note
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.data.NotesDataSource
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.screen.NoteViewModel
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.screen.NotesApp
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.screen.NotesScreen
import com.artemissoftware.jetpackcomposetutorial3.ui.theme.JetPackComposeTutorial3Theme
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.ToTheMovies
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.navigation.MovieNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

                //val viewModel: NoteViewModel by viewModels<NoteViewModel>() //alternative
                val viewModel: NoteViewModel by viewModels()
                NotesApp(noteViewModel = viewModel)


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