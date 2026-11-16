package com.auther.launcher.launcher

import java.io.File
import java.util.Properties

class InstanceManager(
    private val gameDirectory: File
) {
    private val instancesDirectory =
        File(gameDirectory, "instances")

    fun createInstance(name: String, version: String): Boolean {
        if (name.isBlank() || version.isBlank()) return false

        val safeName = name.trim()
        val instanceFolder = File(instancesDirectory, safeName)

        if (instanceFolder.exists()) return false

        if (!instanceFolder.mkdirs()) return false

        val properties = Properties().apply {
            setProperty("name", safeName)
            setProperty("version", version)
        }

        return try {
            File(instanceFolder, "instance.properties")
                .outputStream()
                .use { properties.store(it, "AUTHER Launcher Instance") }

            true
        } catch (e: Exception) {
            instanceFolder.deleteRecursively()
            false
        }
    }

    fun getInstances(): List<String> {
        if (!instancesDirectory.exists()) return emptyList()

        return instancesDirectory.listFiles()
            ?.filter {
                it.isDirectory &&
                File(it, "instance.properties").isFile
            }
            ?.map { it.name }
            ?: emptyList()
    }

    fun deleteInstance(name: String): Boolean {
        if (name.isBlank()) return false

        val folder = File(instancesDirectory, name)

        // Hanya hapus folder instance langsung di direktori instances.
        if (folder.parentFile?.canonicalFile != instancesDirectory.canonicalFile) {
            return false
        }

        return folder.exists() && folder.isDirectory &&
                folder.deleteRecursively()
    }
}
