package com.horizon.powerup

import android.os.Environment
import java.io.File

object ExternalFileManager {

    private val ROOT_PATH = Environment.getExternalStorageDirectory().absolutePath + "/TradingApp/"

    init {
        makeDirs(ROOT_PATH)
    }

    fun makeDirs(path: String) {
        val fileDir = File(path)
        if (!fileDir.exists()) {
            fileDir.mkdirs()
        }
    }

    fun getFile(fileName: String): File {
        return File(ROOT_PATH + fileName)
    }

    fun removeFile(fileName: String) {
        try {
            val file = getFile(fileName)
            file.delete()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}