package com.horizon.powerup.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.horizon.powerup.R
import com.horizon.powerup.ui.main.MainFragment


object Navigator {

    private var container: Container? = null

    private fun replace(target: Fragment, addBackStack: Boolean = false) {
        container?.run {
            getHostFragmentManager().beginTransaction().apply {
                setCustomAnimations(
                    R.anim.fade_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.fade_out
                )
                replace(getHostContainerId(), target)
                if (addBackStack) {
                    addToBackStack(target.javaClass.name)
                }
            }.commit()
        }
    }

    fun backToLastScreen() {
        container?.run {
            getHostFragmentManager().popBackStack()
        }
    }

    fun toMainScreen() {
        replace(MainFragment.newInstance())
    }

    interface Container {
        fun getHostFragmentManager(): FragmentManager

        fun getHostContainerId(): Int

        fun attachNavigator() {
            container = this
        }

        fun detachNavigator() {
            container = null
        }
    }
}