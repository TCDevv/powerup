package com.horizon.powerup.utils

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_VPN
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import com.horizon.powerup.utils.ConnectionType.DATA
import com.horizon.powerup.utils.ConnectionType.NONE
import com.horizon.powerup.utils.ConnectionType.VPN
import com.horizon.powerup.utils.ConnectionType.WIFI

enum class ConnectionType {
    NONE,
    DATA,
    WIFI,
    VPN
}

fun getConnectionType(context: Context): ConnectionType {
    // Returns connection type.
    // 0: Not available
    // 1: Mobile data
    // 2: Wifi
    // 3: VPN
    (context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?)?.run {
        getNetworkCapabilities(activeNetwork)?.run {
            when {
                hasTransport(TRANSPORT_CELLULAR) -> return DATA
                hasTransport(TRANSPORT_WIFI) -> return WIFI
                hasTransport(TRANSPORT_VPN) -> return VPN
            }

            this
        }
    }

    return NONE
}

fun hasConnection(context: Context): Boolean {
    return getConnectionType(context) != NONE
}