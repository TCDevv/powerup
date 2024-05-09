package com.horizon.powerup.ui

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object Messenger {

    private var container: Container? = null

    fun showSnackBar(message: String) {
        container?.let {
            Snackbar.make(
                it.getHostContentView(), message, Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    fun showToast(message: String) {
        container?.let {
            Toast.makeText(it.getHostContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    interface Container {

        fun getHostContext(): Context

        fun getHostContentView(): View

        fun attachMessenger() {
            container = this
        }

        fun detachMessenger() {
            container = null
        }
    }
}