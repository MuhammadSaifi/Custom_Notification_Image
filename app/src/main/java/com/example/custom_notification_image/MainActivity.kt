package com.example.custom_notification_image

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RemoteViews
import com.example.custom_notification_image.App.Companion.CHANNEL_ID


class MainActivity : AppCompatActivity() {

    private var notificationManager: NotificationManagerCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)
    }
    /*
* RemoteViews
* its a design feature which is work when we drag our image.
* Like in vidmate : it give the some free video when one video completed.
* then we swipe it and watched video removed and new video arrived.
* Its just happend due to RemoteView.
* */


    fun showNotification(v: View) {
        // Collapsed mean when notification arrive then our notification_collapsed.xml
        // will be show on our mobile.
        // when we expand our notification then our second xml file notification_expanded.xml
        // will be show on our mobile.
        // it goes to our NotificationRecevier when we click on it then Toast will shows.

        val collapsedView = RemoteViews(packageName,
                R.layout.notification_collapsed)
        val expandedView = RemoteViews(packageName,
                R.layout.notification_expanded)

        // here we have used intent for that functiones

        // for make the image clickable we have used Pending intent .
        // because here we will not used the Intent View.
// here we can write another name of file where we want to move our functiones
        // when we click on image but here i have used the Receiver class
        val clickIntent = Intent(this, NotificationReceiver::class.java)
        val clickPendingIntent = PendingIntent.getBroadcast(this,
                0, clickIntent, 0)

        // For change Text and Image at the Run time we have used the collapsedView.
        // for change the image and text at the Run time.

        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!")

        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.lotti2)
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build()

        notificationManager!!.notify(1, notification)
    }
}
