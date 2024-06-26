package com.booklibrary.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genres")
data class Genre(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String
)