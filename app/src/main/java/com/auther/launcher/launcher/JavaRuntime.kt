package com.auther.launcher.launcher

import java.io.File

class JavaRuntime(
    private val gameDirectory: File
) {
    private val runtimeDirectory =
        File(gameDirectory, "runtime/current")

    private val javaExecutable = File(
        runtimeDirectory,
        "bin/java"
    )

    fun isInstalled(): Boolean {
        return javaExecutable.isFile &&
                javaExecutable.canExecute()
    }

    fun getJavaExecutable(): File {
        return javaExecutable
    }

    fun getRuntimeDirectory(): File {
        return runtimeDirectory
    }
}
