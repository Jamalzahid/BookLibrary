package com.booklibrary.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.booklibrary.db.entities.Genre


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */

@Dao
interface GenreDao {
    @Query("SELECT * FROM genres ORDER BY name ASC")
    fun getAllGenresSortedByNameAsc(): List<Genre>

    @Query("SELECT * FROM genres ORDER BY name DESC")
    fun getAllGenresSortedByNameDesc(): List<Genre>
}