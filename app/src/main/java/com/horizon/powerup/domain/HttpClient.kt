package com.horizon.powerup.domain

class HttpClient {
    fun get(url: String): String {
        return "get $url"
    }

    fun post(url: String, body: String): String {
        return "post $url $body"
    }
}