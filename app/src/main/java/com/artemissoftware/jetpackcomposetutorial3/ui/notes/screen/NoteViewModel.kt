package com.artemissoftware.jetpackcomposetutorial3.ui.notes.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.data.Note
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.data.NotesDataSource
import com.artemissoftware.jetpackcomposetutorial3.ui.notes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
): ViewModel() {

    private var _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init{

        viewModelScope.launch(Dispatchers.IO) {

            noteRepository.getAllNotes().distinctUntilChanged().collect { listOfNotes->

                if(listOfNotes.isNullOrEmpty()){

                }
                else{
                    _noteList.value = listOfNotes
                }

            }
        }

    }


    fun addNote(note: Note){
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun updateNote(note: Note){
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

    fun removeNote(note: Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }


}