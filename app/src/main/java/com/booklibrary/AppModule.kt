package com.booklibrary

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.booklibrary.db.LibraryDatabase
import com.booklibrary.db.dao.AuthorDao
import com.booklibrary.db.dao.BookDao
import com.booklibrary.db.dao.GenreDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): LibraryDatabase {
        // Room database setup
        val roomBuilder =
            Room.databaseBuilder(application.applicationContext, LibraryDatabase::class.java, "dataBase.db")
                // Add migrations if needed (consult Room documentation)
                .fallbackToDestructiveMigration() // Use with caution for data loss prevention
                .build()
        return roomBuilder
    }

    @Provides
    @Singleton
    fun provideBookDao(database: LibraryDatabase): BookDao {
        return database.bookDao()
    }

    @Provides
    @Singleton
    fun provideAuthorDao(database: LibraryDatabase): AuthorDao {
        return database.authorDao()
    }

    @Provides
    @Singleton
    fun provideGenerDao(database: LibraryDatabase): GenreDao {
        return database.genreDao()
    }

}


