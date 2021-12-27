package com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.data.DataOrException
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.model.QuestionItem
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository)
    : ViewModel() {


    val data: MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception("")) )


    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {

            data.value.loading = true
            data.value = repository.getAllQuestions()

            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }

    }

    fun getTotalQUestionCount(): Int{
        return data.value.data?.toMutableList()?.size!!
    }
}