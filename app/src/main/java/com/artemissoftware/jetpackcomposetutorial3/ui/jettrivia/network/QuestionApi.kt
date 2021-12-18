package com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.network

import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.model.Question
import retrofit2.http.GET

interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Question
}