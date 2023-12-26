package com.example.computervoicesystems.data.room

import com.example.computervoicesystems.data.room.dao.MovieDao
import com.example.computervoicesystems.domain.model.MovieDataClass
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RoomRepository @Inject constructor(
    private val movieDao: MovieDao
) {


    suspend fun addToWatchlist(movie: MovieDataClass) {
        movieDao.insertMovie(movie)
    }

    suspend fun removeFromWatchlist(movieId: Int) {
        movieDao.removeFromWatchlist(movieId)
    }

    fun getBookmarkedMovies(): Flow<List<MovieDataClass>> {
        return movieDao.getBookmarkedMovies()
    }

    suspend fun getIfTheMovieIsBookmarked(movieId: Int): Boolean {
        return movieDao.getMovieId(movieId) != null
    }

    fun getAllMovies(): Flow<List<MovieDataClass>> {
        return movieDao.getAllMovies()
    }

}