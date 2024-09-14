package com.example.to_dolist

import androidx.room.Entity
import androidx.room.PrimaryKey
 @Entity
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val  title :String,
    val time :String,
    val date :String
)
