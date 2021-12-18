package com.artemissoftware.jetpackcomposetutorial3.ui.notes.data

import androidx.room.*

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from notes")
    fun getNotes(): List<Note>

    @Query("SELECT * from notes WHERE id =:id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from notes")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)
}