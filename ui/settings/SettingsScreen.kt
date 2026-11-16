package com.auther.launcher.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    var ram by remember { mutableFloatStateOf(4f) }
    var guiScale by remember { mutableFloatStateOf(2f) }

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Settings", fontSize = 24.sp)

        Text("RAM: ${ram.toInt()} GB")
        Slider(
            value = ram,
            onValueChange = { ram = it },
            valueRange = 1f..8f
        )

        Text("GUI Scale: ${guiScale.toInt()}")
        Slider(
            value = guiScale,
            onValueChange = { guiScale = it },
            valueRange = 1f..4f
        )

        Text("Java Runtime")
        Text("Video Settings")
        Text("Audio Settings")
        Text("Performance Settings")
    }
}
