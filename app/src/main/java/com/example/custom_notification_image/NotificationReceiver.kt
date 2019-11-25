package com.example.custom_notification_image

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

import androidx.core.app.NotificationManagerCompat


// <receiver android:name=".NotificationReceiver" />
// above tag declared in our AndroidManifest.xml
// this class will receive our notificationes.
// we have override on functiones in it.
// when notificatione received then what will do this will decide.

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

     //   Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()


        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.cancel(1)
    }
}
