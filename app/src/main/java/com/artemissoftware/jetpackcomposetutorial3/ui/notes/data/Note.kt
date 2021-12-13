package com.artemissoftware.jetpackcomposetutorial3.ui.notes.data

import java.time.LocalDateTime
import java.util.*

class Note (
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()

)