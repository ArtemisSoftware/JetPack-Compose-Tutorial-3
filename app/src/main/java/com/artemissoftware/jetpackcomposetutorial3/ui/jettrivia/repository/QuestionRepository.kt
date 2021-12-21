package com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.repository

import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.data.DataOrException
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.model.QuestionItem
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()
}