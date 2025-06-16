package com.example.autoreply

import androidx.room.*

@Dao
interface AutoReplyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(autoReply: AutoReply)

    @Query("SELECT reply FROM AutoReply WHERE message = :incoming LIMIT 1")
    fun getReply(incoming: String): String?
}
