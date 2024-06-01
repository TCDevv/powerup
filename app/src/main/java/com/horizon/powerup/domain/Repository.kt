package com.horizon.powerup.domain

class Repository(
    private val httpClient: HttpClient
) {
    fun getUserInfo(url: String): String {
        return httpClient.get(url)
    }

    fun createUser(url: String, username: String, password: String): String {
        return httpClient.post(url, username)
    }
}