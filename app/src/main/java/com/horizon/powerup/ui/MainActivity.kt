package com.horizon.powerup.ui

import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.horizon.powerup.R

class MainActivity : AppCompatActivity(), Navigator.Container {
    private companion object {
        private const val REQUEST_IGNORE_BATTERY_OPTIMIZATION = 1
    }

    private var onRecentBackPressedTime: Long = 0

    private var permissionLauncher: ActivityResultLauncher<Int>? = null

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