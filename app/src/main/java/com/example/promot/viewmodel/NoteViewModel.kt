package com.example.promot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.promot.repository.NotesRepository
import com.example.promot.roomdb.Note
import kotlinx.coroutines.launch

class NoteViewModel (private val repository: NotesRepository) : ViewModel()
 {
    val allNotes = repository.allNotes
        fun insert(note: Note) = viewModelScope.launch {
            repository.insert(note)
        }
    }

