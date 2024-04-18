package com.booklibrary.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.booklibrary.dataModel.BookWithAuthorAndGenre
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


@Dao
interface BookDao {
    @Query("SELECT * FROM books INNER JOIN authors WHERE authors.name = :authorName")
    fun getBooksByAuthor(authorName: String): List<Book>

    @Query("SELECT * FROM books INNER JOIN genres WHERE genres.name = :genreName")
    fun getBooksByGenre(genreName: String): List<Book>

    @Query("SELECT * FROM books WHERE publicationYear = :year")
    fun getBooksByYear(year: Int): List<Book>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAuthor(author: Author)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGenre(genre: Genre)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBook(book: Book)

    // Insert all data in a single transaction
    @Transaction
    suspend fun insertAllData(authors: List<Author>, genres: List<Genre>, books: List<Book>) {
        authors.forEach { insertAuthor(it) }
        genres.forEach { insertGenre(it) }
        books.forEach { insertBook(it) }
    }
    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
            "FROM books " +
            "INNER JOIN authors ON books.author_id = authors.author_id " +
            "INNER JOIN genres ON books.genre_id = genres.id")
    suspend fun getAllBooks(): List<BookWithAuthorAndGenre>


    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
                "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY books.title ASC"
    )
    fun getBooksSortedByTitleAscending(): List<BookWithAuthorAndGenre>

    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
                "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY books.title DESC"
    )
    fun getBooksSortedByTitleDescending(): List<BookWithAuthorAndGenre>

    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
                "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY authors.name ASC"
    )
    fun getBooksSortedByAuthorNameAscending(): List<BookWithAuthorAndGenre>

    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
                "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY authors.name DESC"
    )
    fun getBooksSortedByAuthorNameDescending(): List<BookWithAuthorAndGenre>

    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
                "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY books.publicationYear ASC"
    )
    fun getBooksSortedByPublicationYearAscending(): List<BookWithAuthorAndGenre>

    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
                "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY books.publicationYear DESC"
    )
    fun getBooksSortedByPublicationYearDescending(): List<BookWithAuthorAndGenre>

    @Query(
        "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
                "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY genres.name ASC"
    )
    fun getBooksSortedByGenreAscending(): List<BookWithAuthorAndGenre>
 @Query(
     "SELECT books.id AS id, books.title AS title, authors.name AS authorName, authors.nationality AS author_nationality, genres.name AS genreName, genres.description AS genre_description, books.genre_id, books.author_id, books.publicationYear " +
             "FROM books " +
                "INNER JOIN authors ON books.author_id = authors.author_id " +
                "INNER JOIN genres ON books.genre_id = genres.id " +
                "ORDER BY genres.name DESC"
    )
    fun getBooksSortedByGenreDescending(): List<BookWithAuthorAndGenre>
}
