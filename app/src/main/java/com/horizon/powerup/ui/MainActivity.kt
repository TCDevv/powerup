package com.horizon.powerup.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.horizon.powerup.R

class MainActivity : AppCompatActivity(), Navigator.Container, Messenger.Container {


    private companion object {
        private const val REQUEST_IGNORE_BATTERY_OPTIMIZATION = 1
    }

    private var onRecentBackPressedTime: Long = 0

    private var permissionLauncher: ActivityResultLauncher<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachNavigator()
        attachMessenger()

        registerPermissionLauncher()

        forceRequirementToUse()
    }

    override fun onDestroy() {
        detachMessenger()
        detachNavigator()
        super.onDestroy()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is OnBackPressedListener && it.onBackPressed()) {
                return
            }
        }
        if (System.currentTimeMillis() - onRecentBackPressedTime > 2000) {
            onRecentBackPressedTime = System.currentTimeMillis()
            Messenger.showToast("Please press BACK again to exit")
            return
        }
        super.onBackPressed()
    }

    override fun getHostFragmentManager(): FragmentManager {
        return supportFragmentManager
    }

    override fun getHostContainerId(): Int {
        return R.id.screenContainer
    }

    override fun getHostContext(): Context {
        return this
    }

    override fun getHostContentView(): View {
        return findViewById(android.R.id.content)
    }

    private fun registerPermissionLauncher() {
        permissionLauncher = registerForActivityResult(
            object : ActivityResultContract<Int, Int>() {

                var type = 0

                @SuppressLint("BatteryLife")
                override fun createIntent(context: Context, input: Int): Intent {
                    when (input) {
                        REQUEST_IGNORE_BATTERY_OPTIMIZATION -> {
                            return Intent().apply {
                                action = Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                                data = Uri.parse("package:$packageName")
                            }
                        }

                        else -> throw Exception("Unknown type to request.")
                    }
                }

                override fun parseResult(resultCode: Int, intent: Intent?): Int {
                    return type
                }

            }
        ) { forceRequirementToUse() }
    }


    private fun forceRequirementToUse() {
        if (isBatteryOptimizationEnabled()) {
            requestIgnoreBatteryOptimization()
            return
        }

        onReadyToUse()
    }

    private fun isBatteryOptimizationEnabled(): Boolean {
        return !(getSystemService(POWER_SERVICE) as PowerManager)
            .isIgnoringBatteryOptimizations(packageName)
    }

    private fun requestIgnoreBatteryOptimization() {
        permissionLauncher?.launch(REQUEST_IGNORE_BATTERY_OPTIMIZATION)
    }


    private fun onReadyToUse() {
        Navigator.toMainScreen()
    }
}