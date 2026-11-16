package com.auther.launcher.data

data class LauncherSettings(
    val ramMb: Int = 2048,
    val guiScale: Int = 3,
    val touchControls: Boolean = true,
    val joystickEnabled: Boolean = true,
    val mouseCapture: Boolean = false,
    val keyboardEnabled: Boolean = true,
    val selectedVersion: String = "1.21.1"
)
