package com.horizon.powerup

import android.app.Application
import com.horizon.powerup.di.Injector


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val appName = getString(R.string.app_name)
        val isDebug = BuildConfig.DEBUG
        Injector.install(appName,isDebug)
    }
}