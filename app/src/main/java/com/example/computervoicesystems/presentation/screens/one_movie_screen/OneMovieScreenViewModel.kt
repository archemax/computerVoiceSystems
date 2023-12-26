package com.example.computervoicesystems.presentation.screens.one_movie_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.computervoicesystems.data.Repository
import com.example.computervoicesystems.data.room.RoomRepository
import com.example.computervoicesystems.domain.model.MovieDataClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OneMovieScreenViewModel @Inject constructor(
    savedState: SavedStateHandle,
    private val repository: Repository,
    private val roomRepository: RoomRepository,
) : ViewModel() {
    val isBookmarked = MutableStateFlow(false)
    val movie = MutableStateFlow<MovieDataClass?>(null)

    init {
        val id = savedState.get<String>("id")?.toIntOrNull() ?: 0
        viewModelScope.launch {

            isBookmarked.value = roomRepository.getIfTheMovieIsBookmarked(id)

            repository.listOfMovies.collect { newMovies ->
                movie.value = newMovies.find { it.id == id }
            }
        }
    }
    fun addToWatchlist(movie: MovieDataClass) {
        viewModelScope.launch {
            roomRepository.addToWatchlist(movie)
            isBookmarked.value = true
        }
    }
    fun removeFromWatchlist(movieId: Int) {
        viewModelScope.launch {
            roomRepository.removeFromWatchlist(movieId)
            isBookmarked.value = false
        }
    }


}