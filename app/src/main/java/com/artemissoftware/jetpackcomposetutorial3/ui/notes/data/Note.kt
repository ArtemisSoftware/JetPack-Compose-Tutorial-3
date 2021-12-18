package com.artemissoftware.jetpackcomposetutorial3.ui.notes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "notes")
class Note (

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name ="title")
    val title: String,

    @ColumnInfo(name ="description")
    val description: String,

    @ColumnInfo(name ="entryDate")
    val entryDate: Date = Date.from(Instant.now())

)