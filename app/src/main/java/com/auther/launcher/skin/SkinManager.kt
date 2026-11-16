package com.auther.launcher.skin

import java.io.File

class SkinManager(private val filesDir: File) {

    private val skinDirectory = File(filesDir, "skins")

    fun importSkin(source: File, name: String): Boolean {
        if (!source.isFile || !source.extension.equals("png", true)) {
            return false
        }

        if (name.isBlank()) return false

        return try {
            if (!skinDirectory.exists()) skinDirectory.mkdirs()

            val destination = File(skinDirectory, "${name.trim()}.png")
            source.copyTo(destination, overwrite = true)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getSkins(): List<File> {
        return skinDirectory.listFiles()
            ?.filter { it.isFile && it.extension.equals("png", true) }
            ?: emptyList()
    }

    fun deleteSkin(name: String): Boolean {
        if (name.isBlank() || name.contains("/") || name.contains("\\")) {
            return false
        }

        return File(skinDirectory, "$name.png").delete()
    }
}
