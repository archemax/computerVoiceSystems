package com.example.computervoicesystems.di

import android.content.Context
import androidx.room.Room
import com.example.computervoicesystems.data.room.MovieDatabase
import com.example.computervoicesystems.data.room.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(
        @ApplicationContext context: Context
    ): MovieDatabase =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            MovieDatabase.DATABASE_NAME
        ).build()


    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }
}