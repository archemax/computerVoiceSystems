package com.example.computervoicesystems.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.computervoicesystems.data.room.dao.MovieDao
import com.example.computervoicesystems.domain.model.MovieDataClass

@Database(
    entities = [MovieDataClass::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao


    companion object {
        const val DATABASE_NAME = "movie_database"
    }
}