package com.example.computervoicesystems.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.computervoicesystems.domain.model.MovieDataClass
import kotlinx.coroutines.flow.Flow



@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieDataClass)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MovieDataClass>>

    @Query("SELECT id FROM movies WHERE id = :movieId")
    suspend fun getMovieId(movieId: Int): Int?

    @Query("DELETE FROM movies WHERE id = :movieId")
    suspend fun removeFromWatchlist(movieId: Int)

    @Query("SELECT * FROM movies WHERE isBookmarked = 1")
    fun getBookmarkedMovies(): Flow<List<MovieDataClass>>
}