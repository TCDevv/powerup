package com.horizon.powerup

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintStream

object CriticalLogHelper {

    private const val TAG = "CriticalLogHelper"

    private const val DIRECTORY_TYPE = ""
    private const val FILE_NAME = "crash_log.txt"

    fun writeLog(context: Context, log: String) {
        context.getExternalFilesDir(DIRECTORY_TYPE)?.let { root ->
            try {
                val file = File(root.absolutePath, FILE_NAME)
                val stream = FileOutputStream(file)
                val writer = OutputStreamWriter(stream)
                writer.write(log)
                writer.close()
                stream.close()
            } catch (_: Exception) {
            }
        }
    }

    fun writeLog(context: Context, throwable: Throwable) {
        context.getExternalFilesDir(DIRECTORY_TYPE)?.let { root ->
            try {
                val file = File(root.absolutePath, FILE_NAME)
                val stream = PrintStream(file)
                throwable.printStackTrace(stream)
                stream.close()
            } catch (_: Exception) {
            }
        }
    }

    fun showOnConsole(context: Context): Boolean {
        context.getExternalFilesDir(DIRECTORY_TYPE)?.let { root ->
            try {
                val file = File(root.absolutePath, FILE_NAME)
                val stream = FileInputStream(file)
                val reader = InputStreamReader(stream)

                val log = reader.readText()
                if (log.isNotEmpty()) {
                    Log.e(TAG, log)
                    return true
                }

                reader.close()
                stream.close()
            } catch (_: Exception) {
            }
        }
        return false
    }
}