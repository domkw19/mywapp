package com.example.autoreply

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AutoReply::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun autoReplyDao(): AutoReplyDao
}
