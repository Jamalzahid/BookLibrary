package com.booklibrary.utils

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

val authors = listOf(
    Author(author_id = 0, "Harper Lee", "American", 1926),
    Author(author_id = 1, "George Orwell", "British", 1903),
    Author(author_id = 2, "F. Scott Fitzgerald", "American", 1896),
    Author(author_id = 3, "Jane Austen", "British", 1775),
    Author(author_id = 4, "J.D. Salinger", "American", 1919),
    Author(author_id = 5, "J.R.R. Tolkien", "British", 1892),
    Author(author_id = 6, "J.K. Rowling", "British", 1965),
    Author(author_id = 7, "Aldous Huxley", "British", 1894),
    Author(author_id = 8, "Mary Shelley", "British", 1797)
)

val genres = listOf(
    Genre(
        id = 0,
        "Fiction",
        "A literary genre that deals with imaginary and imaginative characters, events, and settings."
    ),
    Genre(
        id = 1,
        "Dystopian",
        "A subgenre of speculative fiction, exploring social and political structures in an imagined world."
    ),
    Genre(
        id = 2,
        "Classic",
        "A work of literature that is considered to be of high quality and lasting value."
    ),
    Genre(id = 3, "Romance", "A genre focusing on romantic love and relationships."),
    Genre(
        id = 4,
        "Coming-of-age",
        "A genre that focuses on the psychological and moral growth of the protagonist from youth to adulthood."
    ),
    Genre(
        id = 5,
        "Fantasy",
        "A genre that uses magic and other supernatural phenomena as a primary plot element."
    ),
    Genre(id = 6, "Gothic", "A genre that combines elements of horror, death, and romance.")
)

val books = listOf(
    Book(
        id = 1,
        title = "To Kill a Mockingbird",
        authorName = authors[0].name,
        genreName = genres[0].name,
        genreId = 0, authorId = 0,
        publicationYear = 1960
    ),
    Book(
        2,
        "1984",
        authors[1].name,
        genres[1].name,
        genreId = 1,
        authorId = 1,
        publicationYear = 1949
    ),
    Book(
        3,
        "The Great Gatsby",
        authors[2].name,
        genres[2].name,
        genreId = 2,
        authorId = 2,
        publicationYear = 1925
    ),
    Book(
        4,
        "Pride and Prejudice",
        authors[3].name,
        genres[3].name,
        genreId = 3,
        authorId = 3,
        publicationYear = 1813
    ),
    Book(
        5,
        "The Catcher in the Rye",
        authors[4].name,
        genres[4].name,
        genreId = 4,
        authorId = 4,
        publicationYear = 1951
    ),
    Book(
        6,
        "The Lord of the Rings",
        authors[5].name,
        genres[5].name,
        genreId = 5,
        authorId = 5,
        publicationYear = 1954
    ),
    Book(
        7,
        "Harry Potter and the Sorcerer's Stone",
        authors[6].name,
        genres[5].name,
        genreId = 5,
        authorId = 6,
        publicationYear = 1997
    ),
    Book(
        8,
        "The Hobbit",
        authors[5].name,
        genres[5].name,
        genreId = 5,
        authorId = 5,
        publicationYear = 1937
    ),
    Book(
        9,
        "Brave New World",
        authors[7].name,
        genres[1].name,
        genreId = 1,
        authorId = 7,
        publicationYear = 1932
    ),
    Book(
        10,
        "Frankenstein",
        authors[8].name,
        genres[6].name,
        genreId = 6,
        authorId = 8,
        publicationYear = 1818
    )
)


