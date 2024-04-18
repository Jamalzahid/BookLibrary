package com.booklibrary.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.booklibrary.db.entities.Author


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */

@Dao
interface AuthorDao {
    @Query("SELECT * FROM authors WHERE nationality = :nationality")
    fun getAuthorsByNationality(nationality: String): List<Author>
    @Query("SELECT * FROM authors ORDER BY name ASC")
    fun getAllAuthorsSortedByNameAsc(): List<Author>

    @Query("SELECT * FROM authors ORDER BY name DESC")
    fun getAllAuthorsSortedByNameDesc(): List<Author>

}