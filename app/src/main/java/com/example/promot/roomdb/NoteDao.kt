package com.example.promot.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)  // ham tao ngung tyrong crotine dung cac thao tac ma khogn bi cha

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<Note>>

}