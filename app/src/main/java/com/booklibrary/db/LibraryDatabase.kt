package com.booklibrary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.booklibrary.db.dao.AuthorDao
import com.booklibrary.db.dao.BookDao
import com.booklibrary.db.dao.GenreDao
import com.booklibrary.db.entities.Author
import com.booklibrary.db.entities.Book
import com.booklibrary.db.entities.Genre


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */


@Database(entities = [Book::class, Author::class, Genre::class], version = 1)
abstract class LibraryDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun authorDao(): AuthorDao
    abstract fun genreDao(): GenreDao

}
