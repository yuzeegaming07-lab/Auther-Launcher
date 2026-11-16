package com.auther.launcher.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.auther.launcher.ui.components.SettingGroup

@Composable
fun SettingsScreen() {
    var ram by remember { mutableFloatStateOf(2048f) }
    var guiScale by remember { mutableIntStateOf(3) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        SettingGroup("Memory") {
            Text("RAM: ${ram.toInt()} MB")

            Slider(
                value = ram,
                onValueChange = { ram = it },
                valueRange = 512f..8192f,
                steps = 14
            )
        }

        SettingGroup("Interface") {
            Text("GUI Scale: $guiScale")

            Slider(
                value = guiScale.toFloat(),
                onValueChange = { guiScale = it.toInt() },
                valueRange = 1f..6f,
                steps = 4
            )
        }

        SettingGroup("Java Runtime") {
            Text("Manage Java Runtime")
        }

        SettingGroup("Performance") {
            Text("Renderer and performance options")
        }

        SettingGroup("Audio & Video") {
            Text("Audio and video options")
        }
    }
}
