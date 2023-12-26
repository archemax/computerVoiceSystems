package com.example.computervoicesystems.presentation.screens.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.computervoicesystems.R
import com.example.computervoicesystems.domain.model.MovieDataClass
import com.example.computervoicesystems.presentation.components.CategoryDivider
import com.example.computervoicesystems.presentation.components.ListHeader

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel = hiltViewModel(),
    navController: NavController,
    toOneMovieScreen: (MovieDataClass) -> Unit,
) {

    var showDialog by rememberSaveable { mutableStateOf(false) }
    val state: State<List<MovieDataClass>> = mainScreenViewModel.state.collectAsState()
    val allMoviesList by mainScreenViewModel.flowFromDataBase.collectAsState(listOf())

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 16.dp)
                .fillMaxSize(),

            ) {
            Row(modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp)
                .clickable { showDialog = true }) {
                Text(text = stringResource(R.string.sort), style = MaterialTheme.typography.bodyLarge)
            }

            if (showDialog) {
                SortDialog(
                    onDismiss = { showDialog = false },
                    onSortSelected = { sortingOption ->
                        showDialog = false
                    },
                    sortByTitle = { mainScreenViewModel.sortMoviesByTitle() },
                    sortByDate = { mainScreenViewModel.sortMoviesByDate() },
                    sortByDefault = {mainScreenViewModel.sortByDefault()}
                )
            }

            LazyColumn() {
                stickyHeader { ListHeader() }

                items(state.value) { oneMovie ->
                    OneMovieItem(
                        oneMovie = oneMovie,
                        navController = navController,
                        onClick = { toOneMovieScreen(oneMovie) },
                        inWatchList = allMoviesList.contains(oneMovie)
                    )
                    CategoryDivider()
                }
            }
        }
    }
}


@Composable
fun OneMovieItem(
    oneMovie: MovieDataClass,
    navController: NavController,
    onClick: (MovieDataClass) -> Unit,
    inWatchList: Boolean
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(oneMovie) }

    ) {
        Image(
            painter = painterResource(id = oneMovie.imageResId),
            contentDescription = stringResource(R.string.movie_poster),
            modifier = Modifier
                .height(200.dp)
                .width(150.dp)
                .scale(1f),
            contentScale = ContentScale.FillHeight

        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically),
            ) {

            val yearOfRelease = oneMovie.releasedDate
            val yyyy = yearOfRelease.takeLast(4)

            Text(
                text = "${oneMovie.title} ($yyyy)",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "${oneMovie.duration} - ${oneMovie.genre}",
                style = MaterialTheme.typography.labelSmall
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = if (inWatchList) {
                    stringResource(R.string.on_my_watchlist)
                } else {
                    ""
                },
                style = MaterialTheme.typography.bodyLarge
            )

        }
    }
}



