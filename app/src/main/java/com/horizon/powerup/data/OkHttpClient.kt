package com.horizon.powerup.data

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class OkHttpClient {
    private val client = OkHttpClient()
    companion object{
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    fun synchronousGet(endpoint:String):String{
        val request = Request.Builder().url(BASE_URL+endpoint).build()
        val response = client.newCall(request).execute()
        return response.body!!.string()
    }

    fun asynchronousGet(endpoint:String,callback: (String?, Exception?) -> Unit) {
        val request = Request.Builder().url(BASE_URL+endpoint).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback(null, e) // Pass exception to callback on failure
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    callback(response.body?.string(), null) // Pass result to callback on success
                } else {
                    callback(null, IOException("Unexpected code $response")) // Pass exception for unsuccessful response
                }
            }
        })
    }
}