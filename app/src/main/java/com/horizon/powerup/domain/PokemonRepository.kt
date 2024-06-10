package com.horizon.powerup.domain

import com.horizon.powerup.data.OkHttpClient

class PokemonRepository(
    private val okHttpClient: OkHttpClient
) {
    fun getPokemonList(id: Int? = null, name: String? = null):String {
        if(id == null && name == null){
            throw IllegalArgumentException("Either id or name must be provided")
        }
        val endpoint = when {
            id != null -> "pokemon/$id"
            name != "" -> "pokemon/$name"
            else -> "pokemon"
        }
        return okHttpClient.synchronousGet(endpoint);
    }
}