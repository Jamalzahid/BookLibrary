package com.booklibrary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booklibrary.dataModel.BookWithAuthorAndGenre
import com.booklibrary.utils.SortBy
import com.booklibrary.repo.LibraryRepository
import com.booklibrary.db.entities.Author
import com.booklibrary.db.entities.Book
import dagger.hilt.android.lifecycle.HiltViewModel
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


@HiltViewModel
class LibraryViewModel @Inject constructor(private val repository: LibraryRepository) : ViewModel() {
    private val allBooks: MutableLiveData<List<BookWithAuthorAndGenre>> = MutableLiveData()
    private var filteredBooks: List<BookWithAuthorAndGenre> = emptyList()


    fun getBooks(): LiveData<List<BookWithAuthorAndGenre>> {
        allBooks.value = repository.getAllBooks()
        return allBooks
    }

    fun filterBooks(query: String?): List<BookWithAuthorAndGenre> {
        query?.let {
            if (it.isEmpty()) {
                return allBooks.value ?: emptyList()
            } else {
                filteredBooks = allBooks.value?.filter { book ->
                    book.title.contains(it, true) ||
                            book.authorName.contains(it, true) ||
                            book.publicationYear.toString().contains(it, true) ||
                            book.author_nationality.toString().contains(it, true) ||
                            book.genre_description.toString().contains(it, true) ||
                            book.genreName.contains(it, true)
                } ?: emptyList()
                return filteredBooks
            }
        } ?: return emptyList()
    }
    fun getAllBooksSorted(sortBy: SortBy): List<BookWithAuthorAndGenre> {
        val books = mutableListOf<BookWithAuthorAndGenre>() // Empty list to store fetched books
        CoroutineScope(Dispatchers.IO).launch{
            books.addAll(repository.getAllBooksSorted(sortBy))
        }
        return books
    }
    fun insertData() = repository.insertData()
    fun getBooksByAuthor(authorId: String): List<Book> = repository.getBooksByAuthor(authorId)
    fun getBooksByGenre(genreId: String): List<Book> = repository.getBooksByGenre(genreId)
    fun getBooksByYear(year: Int): List<Book> = repository.getBooksByYear(year)
    fun getAuthorsByNationality(nationality: String): List<Author> = repository.getAuthorsByNationality(nationality)
}
