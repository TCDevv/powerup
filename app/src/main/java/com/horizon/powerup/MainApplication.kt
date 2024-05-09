package com.horizon.powerup

import android.app.Application
import kotlin.system.exitProcess


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        attachUncaughtExceptionHandler()
        initNotificationCenter()
    }

    private fun attachUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            CriticalLogHelper.writeLog(this, throwable)

            NotificationCenter.newBuilder(this)
                .setTitle("[Fatal Error]")
                .setContent(throwable.toString())
                .setHighPriority()
                .show(999)

            exitProcess(2)
        }
    }

    private fun initNotificationCenter() {
        NotificationCenter.init(this)
    }
}