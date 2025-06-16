package com.example.autoreply

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var dao: AutoReplyDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "auto_reply_db"
        ).allowMainThreadQueries().build()

        dao = db.autoReplyDao()

        val inputMessage = findViewById<EditText>(R.id.inputMessage)
        val inputReply = findViewById<EditText>(R.id.inputReply)
        val saveBtn = findViewById<Button>(R.id.saveButton)
        val openSettingsBtn = findViewById<Button>(R.id.settingsButton)

        saveBtn.setOnClickListener {
            val msg = inputMessage.text.toString().trim()
            val reply = inputReply.text.toString().trim()

            if (msg.isNotEmpty() && reply.isNotEmpty()) {
                dao.insert(AutoReply(msg, reply))
                Toast.makeText(this, "تم حفظ الرد التلقائي ✅", Toast.LENGTH_SHORT).show()
                inputMessage.text.clear()
                inputReply.text.clear()
            }
        }

        openSettingsBtn.setOnClickListener {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }
    }
}
