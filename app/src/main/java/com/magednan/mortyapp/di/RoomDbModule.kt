package com.magednan.mortyapp.di

import android.app.Application
import androidx.room.Room
import com.magednan.mortyapp.data.local.Converters
import com.magednan.mortyapp.data.local.MortyRoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDbModule {

    @Provides
    @Singleton
    fun provideRoom(application: Application):MortyRoomDb{
        return Room.databaseBuilder( application,
            MortyRoomDb::class.java,
            "MortyRoomDb")
            .addTypeConverter(Converters())
            .build()
    }

    @Provides
    @Singleton
    fun providesCharacterDao(mortyRoomDb: MortyRoomDb)=mortyRoomDb.getCharacterDao()

    @Provides
    @Singleton
    fun providesEpisodeDao(mortyRoomDb: MortyRoomDb)=mortyRoomDb.getEpisodeDao()

    @Provides
    @Singleton
    fun providesLocationDao(mortyRoomDb: MortyRoomDb)=mortyRoomDb.getLocationDao()
}