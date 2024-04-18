package com.booklibrary

import android.app.Application
import android.content.ContextWrapper
import com.booklibrary.db.LibraryDatabase
import com.pixplicity.easyprefs.library.Prefs
import dagger.hilt.android.HiltAndroidApp


/**
 * @copyright
 * Copyright (c) 2023  M. JAMAL
 * All rights reserved.
 * Created by M. JAMAL on 18/04/2024
 * @author M. JAMAL
 */


@HiltAndroidApp
class LibraryApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Initialize the Prefs class
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}
