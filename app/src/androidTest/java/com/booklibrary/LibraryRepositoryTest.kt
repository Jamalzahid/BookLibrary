package com.booklibrary

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.booklibrary.db.LibraryDatabase
import com.booklibrary.repo.LibraryRepository
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */


@RunWith(AndroidJUnit4::class)
class LibraryRepositoryTest {
    private lateinit var repository: LibraryRepository

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val database = Room.inMemoryDatabaseBuilder(context, LibraryDatabase::class.java).build()
        val bookDao = database.bookDao()
        val authorDao = database.authorDao()
        val genreDao = database.genreDao()
        repository = LibraryRepository(bookDao, authorDao, genreDao)
    }

    @After
    fun tearDown() {
        // Close database
    }

    @Test
    fun testGetAllBooks() {
        // Retrieve books using repository
        val books = repository.getAllBooks()

        // Check if the retrieved list is not empty
        assertFalse(books.isEmpty())
        // Add more assertions as needed
    }
}
