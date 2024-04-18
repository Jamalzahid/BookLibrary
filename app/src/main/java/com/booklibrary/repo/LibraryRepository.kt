package com.booklibrary.repo

import com.booklibrary.dataModel.BookWithAuthorAndGenre
import com.booklibrary.utils.SortBy
import com.booklibrary.db.dao.AuthorDao
import com.booklibrary.db.dao.BookDao
import com.booklibrary.db.dao.GenreDao
import com.booklibrary.db.entities.Author
import com.booklibrary.db.entities.Book
import com.booklibrary.utils.authors
import com.booklibrary.utils.books
import com.booklibrary.utils.genres
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */

class LibraryRepository @Inject constructor(
    private val bookDao: BookDao,
    private val authorDao: AuthorDao,
    private val genreDao: GenreDao
) {


    fun insertData() {
        CoroutineScope(Dispatchers.IO).launch {
            bookDao.insertAllData(authors, genres, books)
        }
    }

    fun getAllBooksSorted(sortBy: SortBy): List<BookWithAuthorAndGenre> {
        return when (sortBy) {
            SortBy.TITLE_ASC -> bookDao.getBooksSortedByTitleAscending()
            SortBy.TITLE_DESC -> bookDao.getBooksSortedByTitleDescending()
            SortBy.AUTHOR_ASC -> bookDao.getBooksSortedByAuthorNameAscending()
            SortBy.AUTHOR_DESC -> bookDao.getBooksSortedByAuthorNameDescending()
            SortBy.PUBLICATION_YEAR_ASC -> bookDao.getBooksSortedByPublicationYearAscending()
            SortBy.PUBLICATION_YEAR_DESC -> bookDao.getBooksSortedByPublicationYearDescending()
            SortBy.GENRE_ASC -> bookDao.getBooksSortedByGenreAscending()
            SortBy.GENRE_DESC -> bookDao.getBooksSortedByGenreDescending()
        }
    }

    fun getAllBooks(): List<BookWithAuthorAndGenre> {
        val books = mutableListOf<BookWithAuthorAndGenre>() // Empty list to store fetched books

        CoroutineScope(Dispatchers.IO).launch {
            try {
                books.addAll(bookDao.getAllBooks()) // Add fetched books to the list
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle exceptions (e.g., log the error)
                println("Error fetching books: $e")
            }
        }

        // This line will block until the background job finishes (not ideal for UI)
        // Consider alternative approaches for UI updates if needed.
        return books
    }

    fun getBooksByAuthor(authorId: String): List<Book> = bookDao.getBooksByAuthor(authorId)
    fun getBooksByGenre(genreId: String): List<Book> = bookDao.getBooksByGenre(genreId)
    fun getBooksByYear(year: Int): List<Book> = bookDao.getBooksByYear(year)
    fun getAuthorsByNationality(nationality: String): List<Author> =
        authorDao.getAuthorsByNationality(nationality)
}
