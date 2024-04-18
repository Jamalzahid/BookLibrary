package com.booklibrary.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */

@Entity(tableName = "books",
    foreignKeys = [
        ForeignKey(entity = Genre::class, parentColumns = ["id"], childColumns = ["genre_id"]),
        ForeignKey(entity = Author::class, parentColumns = ["author_id"], childColumns = ["author_id"])
    ]
)

data class Book(
    @PrimaryKey val id: Int,
    val title: String,
    val authorName: String,
    val genreName: String,
    @ColumnInfo(name = "genre_id") val genreId: Int?,
    @ColumnInfo(name = "author_id") val authorId: Int?,
    val publicationYear: Int
)