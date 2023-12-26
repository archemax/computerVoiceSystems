package com.example.computervoicesystems.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieDataClass(

    @PrimaryKey
    val id: Int,

    val title: String,
    val imageResId:Int,
    val description: String,
    val rating: String,
    val duration: String,
    val genre: String,
    val releasedDate: String,
    val trailerLink: String,
    val isBookmarked: Boolean = false

)

