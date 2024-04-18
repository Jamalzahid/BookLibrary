package com.booklibrary

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.booklibrary.adapter.BookAdapter
import com.booklibrary.databinding.ActivityMainBinding
import com.booklibrary.utils.SortBy
import com.booklibrary.viewmodel.LibraryViewModel
import com.pixplicity.easyprefs.library.Prefs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG ="MainTag"
    private val viewModel: LibraryViewModel by viewModels()
     private lateinit var adapter: BookAdapter
     val binding : ActivityMainBinding by lazy {
         ActivityMainBinding.inflate(layoutInflater)
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (!Prefs.getBoolean("inserted",false)){
            viewModel.insertData()
            Prefs.putBoolean("inserted",true)
        }

       binding. searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterBooks(newText)
                return true
            }
        })
        adapter = BookAdapter(emptyList())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Fetch data from ViewModel and update UI
        viewModel.getBooks().observe(this) { books ->

            adapter = BookAdapter(books)
            binding.recyclerView.adapter = adapter
            Log.d(TAG, "onCreate: $books")
        }
        binding.init()
    }
    private fun ActivityMainBinding.init(){
        val buttons = listOf(
            btnSortTitleAsc, btnSortTitleDesc,
            btnSortAuthorAsc, btnSortAuthorDesc,
            btnSortGenreAsc, btnSortGenreDesc,
            btnSortPublicationYearAsc, btnSortPublicationYearDesc
        )
        // Set up click listeners for all buttons
        buttons.forEach { button ->
            button.setOnClickListener {
                // Set background color of clicked button to yellow
                button.setBackgroundColor(Color.BLUE)

                // Set background color of other buttons to green
                buttons.filter { it != button }.forEach { it.setBackgroundColor(Color.GREEN) }

                // Call sortBooks function with the appropriate SortBy enum
                when (button) {
                    btnSortTitleAsc -> sortBooks(SortBy.TITLE_ASC)
                    btnSortTitleDesc -> sortBooks(SortBy.TITLE_DESC)
                    btnSortAuthorAsc -> sortBooks(SortBy.AUTHOR_ASC)
                    btnSortAuthorDesc -> sortBooks(SortBy.AUTHOR_DESC)
                    btnSortGenreAsc -> sortBooks(SortBy.GENRE_ASC)
                    btnSortGenreDesc -> sortBooks(SortBy.GENRE_DESC)
                    btnSortPublicationYearAsc -> sortBooks(SortBy.PUBLICATION_YEAR_ASC)
                    btnSortPublicationYearDesc -> sortBooks(SortBy.PUBLICATION_YEAR_DESC)
                    else -> Unit // Handle default case if needed
                }
            }
        }


    }
    private fun filterBooks(query: String?) {
        val filteredBooks = viewModel.filterBooks(query)
        Log.d(TAG, "sortBooks: $filteredBooks")
        adapter.updateList(filteredBooks)
    }
    private fun sortBooks(sortBy: SortBy) {
        val sortedBooks = viewModel.getAllBooksSorted(sortBy)
        Log.d(TAG, "sortBooks: $sortedBooks")
        adapter.updateList(sortedBooks)
    }
}