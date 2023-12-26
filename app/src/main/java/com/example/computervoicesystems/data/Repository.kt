package com.example.computervoicesystems.data

import android.util.Log
import com.example.computervoicesystems.R
import com.example.computervoicesystems.domain.model.MovieDataClass
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


class Repository @Inject constructor() {

    private val _listOfMovies = MutableStateFlow<List<MovieDataClass>>(emptyList())
    val listOfMovies: Flow<List<MovieDataClass>> get() = _listOfMovies

    init {
        updateMovieList(
            listOf(
                MovieDataClass(
                    id = 1,
                    title = "Tenet",
                    imageResId = R.drawable.tenet,
                    description = "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                    rating = "7.8",
                    duration = "2h 30 min",
                    genre = "Action, Sci-Fi",
                    releasedDate = "3 September 2020",
                    trailerLink = " https://www.youtube.com/watch?v=LdOM0x0XDMo",
                    isBookmarked = false
                ),
                MovieDataClass(
                    id = 2,
                    title = "Spider-Man: Into the Spider-Verse",
                    imageResId = R.drawable.spider_man,
                    description = "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.",
                    rating = "8.4",
                    duration = "1h 57min",
                    genre = "Action, Animation, Adventure",
                    releasedDate = "14 December 2018",
                    trailerLink = "https://www.youtube.com/watch?v=tg52up16eq0",
                    isBookmarked = false

                ),


                MovieDataClass(
                    id = 3,
                    title = "Knives Out",
                    imageResId = R.drawable.knives_out,
                    description = "A detective investigates the death of a patriarch of an eccentric, combative family.",
                    rating = "7.9",
                    duration = "2h 10min",
                    genre = "Comedy, Crime, Drama",
                    releasedDate = "27 November 2019",
                    trailerLink = "https://www.youtube.com/watch?v=qGqiHJTsRkQ",
                    isBookmarked = false
                ),


                MovieDataClass(
                    id = 4,
                    title = "Guardians of the Galaxy",
                    imageResId = R.drawable.guardians_of_the_galaxy,
                    description = "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.",
                    rating = "8.0",
                    duration = "2h 1min",
                    genre = "Action, Adventure, Comedy",
                    releasedDate = "1 August 2014",
                    trailerLink = "https://www.youtube.com/watch?v=d96cjJhvlMA",
                    isBookmarked = false
                ),

                MovieDataClass(
                    id = 5,
                    title = "Avengers: Age of Ultron",
                    imageResId = R.drawable.avengers,
                    description = "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
                    rating = "7.3",
                    duration = "2h 21min",
                    genre = "Action, Adventure, Sci-Fi",
                    releasedDate = "1 May 2015",
                    trailerLink = "https://www.youtube.com/watch?v=tmeOjFno6Do",
                    isBookmarked = false
                ),


                )
        )
    }

    private fun updateMovieList(newList: List<MovieDataClass>) {
        _listOfMovies.value = newList
        Log.d ("list_of_movies_repository","${_listOfMovies.value}")
    }
}

