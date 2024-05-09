package com.horizon.powerup.utils

import android.app.ActivityManager
import android.app.Service
import android.content.Context

//Android O and later, check Local Service only
@Suppress("DEPRECATION")
fun <T : Service> checkServiceRunning(context: Context, clazz: Class<T>): Boolean {
    val manager = context.getSystemService(Service.ACTIVITY_SERVICE) as ActivityManager
    return manager.getRunningServices(Integer.MAX_VALUE)
        .any { it.service.className == clazz.name }
}