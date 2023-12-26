package com.example.computervoicesystems.presentation.screens.main_screen

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
class MainScreenViewModel @Inject constructor(
    repository: Repository,
    roomRepository: RoomRepository
) : ViewModel() {

    private val initialList = repository

    private val _state = MutableStateFlow<List<MovieDataClass>>(emptyList())
    val state: MutableStateFlow<List<MovieDataClass>> = _state

    val flowFromDataBase = roomRepository.getAllMovies()

    init {
        viewModelScope.launch {
            repository.listOfMovies.collect { movies ->
                _state.value = movies

            }
        }
    }

    fun sortByDefault (){
        viewModelScope.launch {
            initialList.listOfMovies.collect { movies ->
                _state.value = movies

            }
        }
    }

    fun sortMoviesByTitle() {
        var myList = emptyList<MovieDataClass>()
        viewModelScope.launch {
            initialList.listOfMovies.collect { movies ->
                myList = movies
            }
        }
        // sorting
        val sortedList = myList.sortedBy {
            it.title
        }
        _state.value = sortedList
    }

    fun sortMoviesByDate(){
        var myList = emptyList<MovieDataClass>()
        viewModelScope.launch {
            initialList.listOfMovies.collect { movies ->
                myList = movies
            }
        }
        val sortedList = myList.sortedBy {
            it.releasedDate
        }
        _state.value = sortedList
    }

}

