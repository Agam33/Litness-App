package com.org.litness.di

import com.org.litness.data.repository.ExerciseRepository
import com.org.litness.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideExerciseRepo(): ExerciseRepository = ExerciseRepository()

    @Provides
    @Singleton
    fun provideUserRepo(): UserRepository = UserRepository()
}