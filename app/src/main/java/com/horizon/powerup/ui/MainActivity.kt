package com.horizon.powerup.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.horizon.powerup.R

class MainActivity : AppCompatActivity(), Navigator.Container {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachNavigator()
    }

    override fun onDestroy() {
        detachNavigator()
        super.onDestroy()
    }

    override fun getHostFragmentManager(): FragmentManager {
        return supportFragmentManager
    }

    override fun getHostContainerId(): Int {
        return R.id.screenContainer
    }
}