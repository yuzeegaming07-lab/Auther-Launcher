package com.auther.launcher.data

import android.content.Context

class SettingsRepository(context: Context) {

    private val preferences = context.getSharedPreferences(
        "auther_launcher_settings",
        Context.MODE_PRIVATE
    )

    fun load(): LauncherSettings {
        return LauncherSettings(
            ramMb = preferences.getInt("ram_mb", 2048),
            guiScale = preferences.getInt("gui_scale", 3),
            touchControls = preferences.getBoolean("touch", true),
            joystickEnabled = preferences.getBoolean("joystick", true),
            mouseCapture = preferences.getBoolean("mouse_capture", false),
            keyboardEnabled = preferences.getBoolean("keyboard", true),
            selectedVersion = preferences.getString("version", "1.21.1")
                ?: "1.21.1"
        )
    }

    fun save(settings: LauncherSettings) {
        preferences.edit()
            .putInt("ram_mb", settings.ramMb)
            .putInt("gui_scale", settings.guiScale)
            .putBoolean("touch", settings.touchControls)
            .putBoolean("joystick", settings.joystickEnabled)
            .putBoolean("mouse_capture", settings.mouseCapture)
            .putBoolean("keyboard", settings.keyboardEnabled)
            .putString("version", settings.selectedVersion)
            .apply()
    }
}
