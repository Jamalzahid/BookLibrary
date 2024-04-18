package com.booklibrary.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */

@Entity(tableName = "authors")
data class Author(
    @PrimaryKey val author_id: Int,
    val name: String,
    val nationality: String,
    val birthYear: Int
)