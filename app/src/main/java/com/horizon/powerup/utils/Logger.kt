package com.horizon.powerup.utils

import android.util.Log

class Logger(private val tag:String, private val isDebug:Boolean) {
    fun log(message: String) {
        if (isDebug) {
            Log.e(tag,message)
        }
    }
}