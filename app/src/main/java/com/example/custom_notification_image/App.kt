package com.example.custom_notification_image

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    // here we have created channels for our notificationes.
    // if android version more then Oreo mean >= 26 then it will work.
    // simply i have created channel and its importance and its id.
    override fun onCreate() {
        super.onCreate()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                    CHANNEL_ID,
                    "Example Channel",
                    NotificationManager.IMPORTANCE_HIGH
            )

            val manager = getSystemService<NotificationManager>(NotificationManager::class.java!!)
            manager!!.createNotificationChannel(channel)
        }
    }

    companion object {

        val CHANNEL_ID = "channel 1"
    }
}
