package com.example.computervoicesystems.presentation.screens.one_movie_screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.computervoicesystems.R
import com.example.computervoicesystems.presentation.components.ArrowBack
import com.example.computervoicesystems.presentation.components.CategoryDivider


@Composable
fun OneMovieScreen(
    navController: NavController,
    oneMovieScreenViewModel: OneMovieScreenViewModel = hiltViewModel()
) {

    val movie by oneMovieScreenViewModel.movie.collectAsState()
    val isBookmarked by oneMovieScreenViewModel.isBookmarked.collectAsState()

    movie?.let { myMovie ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // row with arrow back
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.popBackStack() }
            ) {
                ArrowBack()
            }

            CategoryDivider()

            // row with movie pic, tittle and rating
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            ) {
                Image(
                    painter = painterResource(id = myMovie.imageResId),
                    contentDescription = stringResource(R.string.movie_poster_one_screen),
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(150.dp),
                    contentScale = ContentScale.FillHeight

                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Row() {
                        Text(
                            text = myMovie.title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = myMovie.rating,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "/10",
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.Top)
                        )
                    }

                    Button(
                        onClick = {
                            if (isBookmarked) {
                                oneMovieScreenViewModel.removeFromWatchlist(myMovie.id)
                            } else {
                                oneMovieScreenViewModel.addToWatchlist(myMovie)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.LightGray),
                        modifier = Modifier.wrapContentSize()

                    )

                    {
                        Text(
                            text = if (isBookmarked) {
                                stringResource(R.string.remove_from_watch_list)
                            } else {
                                stringResource(R.string.add_to_watch_list)
                            },
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 10.sp
                        )
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Text(
                            text = stringResource(R.string.watch_trailer),
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

            }

            CategoryDivider()

            // short description of the movie
            Column(modifier = Modifier) {
                Text(
                    text = stringResource(R.string.short_description),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = myMovie.description,
                    style = MaterialTheme.typography.labelSmall
                )
            }

            CategoryDivider()

            // details of the movie
            Column(modifier = Modifier) {
                Row() {
                    Text(
                        text = stringResource(R.string.details),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .weight(0.8f)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.End),
                            text = stringResource(R.string.genre),

                            )
                        Text(
                            modifier = Modifier.align(Alignment.End),
                            text = stringResource(R.string.release_date),

                            )
                    }

                    Column(
                        modifier = Modifier.weight(2f)
                    ) {
                        Text(
                            text = myMovie.genre,
                            modifier = Modifier.align(Alignment.Start),
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis

                        )
                        Text(
                            text = myMovie.releasedDate,
                            modifier = Modifier.align(Alignment.Start),
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis

                        )
                    }
                }

            }
        }
    }
}







