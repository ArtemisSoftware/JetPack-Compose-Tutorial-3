package com.artemissoftware.jetpackcomposetutorial3.ui.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.artemissoftware.jetpackcomposetutorial3.util.DateConverter
import com.artemissoftware.jetpackcomposetutorial3.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDatabaseDao


}