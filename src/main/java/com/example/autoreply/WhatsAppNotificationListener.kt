package com.example.autoreply

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.room.Room

class WhatsAppNotificationListener : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        try {
            if (sbn.packageName == "com.whatsapp") {
                val extras = sbn.notification.extras
                val message = extras.getCharSequence("android.text")?.toString()
                val sender = extras.getCharSequence("android.title")?.toString()

                if (!message.isNullOrEmpty() && !sender.isNullOrEmpty()) {
                    val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "auto_reply_db")
                        .allowMainThreadQueries().build()
                    val dao = db.autoReplyDao()
                    val replyText = dao.getReply(message.trim())

                    if (!replyText.isNullOrEmpty()) {
                        Log.d("AutoReply", "تم الرد على $sender بـ $replyText")
                        // الرد على الرسائل مباشرة يتطلب استخدام Notification.Action، وهذا غير مدعوم رسميًا دائمًا
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("AutoReply", "خطأ في تحليل الإشعار: ${e.message}")
        }
    }
}
