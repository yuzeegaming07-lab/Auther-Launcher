package com.auther.launcher.launcher

import java.io.File

data class LaunchResult(
    val success: Boolean,
    val message: String
)

class MinecraftLauncher(
    private val gameDirectory: File
) {
    private val versionManager = VersionManager(gameDirectory)
    private val javaRuntime = JavaRuntime(gameDirectory)

    fun prepareLaunch(versionId: String): LaunchResult {
        if (versionId.isBlank()) {
            return LaunchResult(false, "Pilih versi Minecraft terlebih dahulu.")
        }

        if (!versionManager.isVersionInstalled(versionId)) {
            return LaunchResult(false, "Versi Minecraft belum terpasang.")
        }

        if (!javaRuntime.isInstalled()) {
            return LaunchResult(false, "Java Runtime belum tersedia.")
        }

        return LaunchResult(
            false,
            "Persiapan selesai, tetapi mesin untuk menjalankan Minecraft belum diintegrasikan."
        )
    }
}
