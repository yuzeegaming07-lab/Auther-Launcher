package com.auther.launcher.launcher

import java.io.File

class VersionManager(
    private val gameDirectory: File
) {
    private val versionsDirectory =
        File(gameDirectory, "versions")

    fun getInstalledVersions(): List<String> {
        if (!versionsDirectory.exists()) return emptyList()

        return versionsDirectory.listFiles()
            ?.filter { folder ->
                folder.isDirectory &&
                File(folder, "${folder.name}.json").isFile &&
                File(folder, "${folder.name}.jar").isFile
            }
            ?.map { it.name }
            ?.sortedDescending()
            ?: emptyList()
    }

    fun isVersionInstalled(versionId: String): Boolean {
        val versionFolder = File(versionsDirectory, versionId)

        return File(versionFolder, "$versionId.json").isFile &&
                File(versionFolder, "$versionId.jar").isFile
    }

    fun getVersionDirectory(versionId: String): File {
        return File(versionsDirectory, versionId)
    }
}
