package com.artemissoftware.jetpackcomposetutorial3.di

import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.network.QuestionApi
import com.artemissoftware.jetpackcomposetutorial3.ui.jettrivia.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi) = QuestionRepository(api)
}