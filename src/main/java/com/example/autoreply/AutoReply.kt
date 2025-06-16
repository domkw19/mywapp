package com.example.autoreply

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AutoReply(
    @PrimaryKey val message: String,
    val reply: String
)
