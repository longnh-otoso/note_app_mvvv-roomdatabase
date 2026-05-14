package com.example.promot.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

  //  @ColumnInfo(name = "title")
    val title: String,
    val description: String,
    val color: Int
)
