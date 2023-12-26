package com.example.computervoicesystems.presentation.screens.main_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.computervoicesystems.R

@Composable
fun SortDialog(
    onDismiss: () -> Unit,
    onSortSelected: (SortingOption) -> Unit,
    sortByTitle: () -> Unit,
    sortByDate: () -> Unit,
    sortByDefault: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    text = stringResource(R.string.sort_by),
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        sortByTitle()
                        onSortSelected(SortingOption.NAME)
                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = stringResource(R.string.sort_by_title), color = Color.Black)
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        sortByDate()
                        onSortSelected(SortingOption.RATING)
                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = stringResource(R.string.sort_by_release_date), color = Color.Black)
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        sortByDefault()
                        onSortSelected(SortingOption.ALL_MOVIES)
                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = stringResource(R.string.all_movies), color = Color.Black)
                }

            }
        }
    }
}


enum class SortingOption {
    NAME,
    RATING,
    ALL_MOVIES
}