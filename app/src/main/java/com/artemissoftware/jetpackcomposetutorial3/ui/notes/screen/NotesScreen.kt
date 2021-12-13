package com.artemissoftware.jetpackcomposetutorial3.ui.notes.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.jetpackcomposetutorial3.R
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.components.NoteInputText
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.data.Note

@ExperimentalComposeUiApi
@Composable
fun NotesScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
){

    var title by remember{ mutableStateOf("")}
    var description by remember{ mutableStateOf("")}

    Column(modifier = Modifier.padding(6.dp)){


        TopAppBar(
            title = {
                    Text(text = stringResource(id = R.string.jet_notes))
            },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "icon")
            },
            backgroundColor = Color.LightGray
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = title,
                label = "Title",
                onTextChange = {
                    if(it.all { char->
                            char.isLetter() || char.isWhitespace()
                    }) title =  it
                }
            )

            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = description,
                label = "Add a note",
                onTextChange = {
                    if(it.all { char->
                            char.isLetter() || char.isWhitespace()
                        }) description =  it
                }
            )

            NoteButton(
                text = "Save",
                onClick = {

                    if(title.isNotEmpty() && description.isNotEmpty()){
                        title = ""
                        description = ""
                    }

                }
            )
        }


    }

}


@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
){

    Button(
        onClick = { onClick() },
        shape= CircleShape,
        enabled = enabled,
        modifier = modifier
    ){
        Text(text = text)
    }

}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun Preview(){
    NotesScreen(notes = emptyList(), onAddNote = {}, onRemoveNote = {})
}