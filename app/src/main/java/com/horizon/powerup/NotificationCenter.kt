package com.horizon.powerup

import android.app.Notification
import android.app.Notification.FOREGROUND_SERVICE_DEFAULT
import android.app.Notification.FOREGROUND_SERVICE_DEFERRED
import android.app.Notification.FOREGROUND_SERVICE_IMMEDIATE
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat


private const val HIGH_CHANNEL_ID = "high_priority_channel"
private const val HIGH_CHANNEL_NAME = "High Priority"

private const val MEDIUM_CHANNEL_ID = "medium_priority_channel"
private const val MEDIUM_CHANNEL_NAME = "Medium Priority"

private const val LOW_CHANNEL_ID = "low_priority_channel"
private const val LOW_CHANNEL_NAME = "Low Priority"

object NotificationCenter {

    private lateinit var notificationManager: NotificationManager

    private val isNotSupportChannel = Build.VERSION.SDK_INT < Build.VERSION_CODES.O

    fun init(context: Context) {
        notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        initChannels()
    }

    private fun initChannels() {
        if (isNotSupportChannel) return

        //Create High Priority Channel
        notificationManager.createNotificationChannel(
            NotificationChannel(
                HIGH_CHANNEL_ID,
                HIGH_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lightColor = Color.BLUE
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            })

        //Create Medium Priority Channel
        notificationManager.createNotificationChannel(
            NotificationChannel(
                MEDIUM_CHANNEL_ID,
                MEDIUM_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.BLUE
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            })

        //Create Low Priority Channel
        notificationManager.createNotificationChannel(
            NotificationChannel(
                LOW_CHANNEL_ID,
                LOW_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                lightColor = Color.BLUE
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            })
    }

    fun cancelNotification(id: Int) {
        notificationManager.cancel(id)
    }

    fun newBuilder(context: Context): Builder {
        return Builder(context)
    }

    class Builder(context: Context) {

        private val builder = NotificationCompat.Builder(context, "")
            .setSmallIcon(R.mipmap.ic_launcher) //Default App Icon

        fun setTitle(title: String) = this.apply {
            builder.setContentTitle(title)
        }

        fun setContent(content: String) = this.apply {
            builder.setContentText(content)
        }

        fun setSmallIcon(icon: Int) = this.apply {
            builder.setSmallIcon(icon)
        }

        fun setHighPriority() = this.apply {
            if (isNotSupportChannel) {
                builder.priority = NotificationCompat.PRIORITY_MAX
            } else {
                builder.setChannelId(HIGH_CHANNEL_ID)
            }
        }

        fun setMediumPriority() = this.apply {
            if (isNotSupportChannel) {
                builder.priority = NotificationCompat.PRIORITY_DEFAULT
            } else {
                builder.setChannelId(MEDIUM_CHANNEL_ID)
            }
        }

        fun setLowPriority() = this.apply {
            if (isNotSupportChannel) {
                builder.priority = NotificationCompat.PRIORITY_LOW
            } else {
                builder.setChannelId(LOW_CHANNEL_ID)
            }
        }

        fun setContentIntent(pendingIntent: PendingIntent) = this.apply {
            builder.setContentIntent(pendingIntent)
        }

        fun setStyle(style: NotificationCompat.Style) = this.apply {
            builder.setStyle(style)
        }

        fun setProgress(max: Int, progress: Int, indeterminate: Boolean) = this.apply {
            builder.setProgress(max, progress, indeterminate)
        }

        fun setForegroundDefault() = this.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                builder.foregroundServiceBehavior = FOREGROUND_SERVICE_DEFAULT
            }
        }

        fun setForegroundDeferred() = this.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                builder.foregroundServiceBehavior = FOREGROUND_SERVICE_DEFERRED
            }
        }

        fun setForegroundImmediately() = this.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                builder.foregroundServiceBehavior = FOREGROUND_SERVICE_IMMEDIATE
            }
        }

        fun build(): Notification {
            return builder.build()
        }

        fun show(id: Int) {
            val notification = build()
            notificationManager.notify(id, notification)
        }
    }
}