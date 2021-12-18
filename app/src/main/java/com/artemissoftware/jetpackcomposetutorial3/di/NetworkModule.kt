package com.artemissoftware.jetpackcomposetutorial3.di

import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.network.QuestionApi
import com.artemissoftware.jetpackcomposetutorial3.util.Constants
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object NetworkModule {

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)

    }
}