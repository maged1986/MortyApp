package com.magednan.mortyapp.di

import com.magednan.mortyapp.data.remote.MortyApi
import com.magednan.mortyapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitApiModule {

    @Provides
    @Singleton
     fun provideRetrofit(): Retrofit {
        val loggingInterceptor= HttpLoggingInterceptor()
        loggingInterceptor.level= HttpLoggingInterceptor.Level.BODY
        val client= OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit by lazy{
            Retrofit.Builder()
                .baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit
    }

    @Provides
    @Singleton
     fun providesApi():MortyApi=
        provideRetrofit().create(MortyApi::class.java)
}