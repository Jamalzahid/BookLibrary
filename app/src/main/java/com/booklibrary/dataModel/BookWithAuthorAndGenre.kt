package com.booklibrary.dataModel

data class BookWithAuthorAndGenre(
    val id: Int,
    val title: String,
    val authorName: String,
    val author_nationality: String?=null,
    val genreName: String,
    val genre_description: String? =null,
    val genre_id: Int?,
    val author_id: Int?,
    val publicationYear: Int
)
