package com.example.promot.repository

import androidx.lifecycle.LiveData
import com.example.promot.roomdb.Note
import com.example.promot.roomdb.NoteDao

class NotesRepository (private val noteDao: NoteDao) {
    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
       return noteDao.insert(note)
    }
}