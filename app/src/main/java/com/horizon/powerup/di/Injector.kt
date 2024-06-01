package com.horizon.powerup.di

import com.horizon.powerup.domain.HttpClient
import com.horizon.powerup.domain.Repository
import com.horizon.powerup.utils.Logger

object Injector {
    private var appName: String = ""
    private var isDebug: Boolean = false
    private var httpClient: HttpClient? = null

    fun install(
        appName: String,
        isDebug: Boolean,
    ) {
        this.appName = appName
        this.isDebug = isDebug
    }

    fun injectLogger(): Logger {
        return Logger(appName, isDebug)
    }

    fun injectHttpClient(): HttpClient {
        if (httpClient == null) {
            httpClient = HttpClient()
        }
        return httpClient!!
    }

    fun injectRepository(): Repository {
        return Repository(injectHttpClient())
    }
}