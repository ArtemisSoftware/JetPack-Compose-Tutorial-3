package com.artemissoftware.jetpackcomposetutorial3.ui.notes.screen

import android.os.Build
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.jetpackcomposetutorial3.R
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.components.NoteInputText
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.data.Note
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.data.NotesDataSource
import java.time.format.DateTimeFormatter

@ExperimentalComposeUiApi
@Composable
fun NotesScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
){

    var title by remember{ mutableStateOf("")}
    var description by remember{ mutableStateOf("")}

    val context = LocalContext.current

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
                        onAddNote(Note(title = title, description = description))
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                    }

                }
            )
        }



        Divider(modifier = Modifier.padding(10.dp))

        LazyColumn{

            items(notes){ note ->
                
                NoteRow(note = note, onNoteClicked = { onRemoveNote(note) })
            }
        }

    }

}


@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){

    val notesList = noteViewModel.getAllNotes()

    NotesScreen(
        notes = notesList,
        onAddNote = {
                    noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        }
    )

}


@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
){

    Surface(modifier = modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
        color = Color (0xFFDFE6EB),
        elevation = 6.dp
    ) {

        Column(modifier = modifier
            .clickable { onNoteClicked(note) }
            .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")), style = MaterialTheme.typography.subtitle2)
            }
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
    NotesScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}