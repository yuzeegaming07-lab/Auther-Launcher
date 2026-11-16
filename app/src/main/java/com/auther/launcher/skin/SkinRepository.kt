package com.auther.launcher.skin

import java.io.File

class SkinRepository(filesDir: File) {

    private val manager = SkinManager(filesDir)

    fun import(file: File, name: String): Boolean {
        return manager.importSkin(file, name)
    }

    fun getAll(): List<File> {
        return manager.getSkins()
    }

    fun delete(name: String): Boolean {
        return manager.deleteSkin(name)
    }
}
