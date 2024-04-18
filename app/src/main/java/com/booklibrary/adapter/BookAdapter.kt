package com.booklibrary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.booklibrary.R
import com.booklibrary.dataModel.BookWithAuthorAndGenre
import com.booklibrary.db.entities.Book


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */


class BookAdapter(private var books: List<BookWithAuthorAndGenre>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBook = books[position]
        holder.titleTextView.text = currentBook.title
        holder.authorTextView.text = "Author: ${currentBook.authorName}"
        holder.genreTextView.text = "Genre: ${currentBook.genreName}"
        holder.yearTextView.text = "Year: ${currentBook.publicationYear}"
        holder.nationality.text = "Nationality: ${currentBook.author_nationality}"
        holder.desc.text = "Description: ${currentBook.genre_description}"
    }

    override fun getItemCount(): Int {
        return books.size
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        val genreTextView: TextView = itemView.findViewById(R.id.genreTextView)
        val yearTextView: TextView = itemView.findViewById(R.id.yearTextView)
        val nationality: TextView = itemView.findViewById(R.id.natation)
        val desc: TextView = itemView.findViewById(R.id.desc)
    }
    fun updateList(newBooks: List<BookWithAuthorAndGenre>) {
        books = newBooks
        notifyDataSetChanged()
    }
}
