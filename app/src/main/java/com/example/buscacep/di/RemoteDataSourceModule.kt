package com.example.buscacep.di

import com.example.buscacep.data.CepRemoteDataSource
import com.example.buscacep.data.CepService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideCepRemoteDataSource(cepService: CepService): CepRemoteDataSource = CepRemoteDataSource(cepService)
}