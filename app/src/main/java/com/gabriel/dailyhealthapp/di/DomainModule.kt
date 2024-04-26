package com.gabriel.dailyhealthapp.di

import com.gabriel.dailyhealthapp.data.repository.auth.AuthFirebaseDataSource
import com.gabriel.dailyhealthapp.data.repository.auth.AuthFirebaseDataSourceImpl
import com.gabriel.dailyhealthapp.data.repository.training.TrainingDataSource
import com.gabriel.dailyhealthapp.data.repository.training.TrainingDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsAuthRepository(
        authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl
    ): AuthFirebaseDataSource
    @Binds
    abstract fun bindsTrainingDataSource(
        trainingDataSourceImpl: TrainingDataSourceImpl
    ): TrainingDataSource
}