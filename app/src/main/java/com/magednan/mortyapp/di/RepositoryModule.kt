package com.magednan.mortyapp.di

import com.magednan.mortyapp.data.repositoryImpl.RepositoryImpl
import com.magednan.mortyapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(RepositoryImpl: RepositoryImpl): Repository
}