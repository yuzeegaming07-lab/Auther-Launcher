package com.auther.launcher.ui.controls

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ControlsScreen() {
    var joystick by remember { mutableStateOf(true) }
    var mouse by remember { mutableStateOf(true) }
    var keyboard by remember { mutableStateOf(true) }
    var touch by remember { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Controls",
            style = MaterialTheme.typography.headlineMedium
        )

        ControlSwitch("Touch Controls", touch) {
            touch = it
        }

        ControlSwitch("Joystick", joystick) {
            joystick = it
        }

        ControlSwitch("Mouse Capture", mouse) {
            mouse = it
        }

        ControlSwitch("Keyboard Support", keyboard) {
            keyboard = it
        }

        Text("Button Mapping")

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Configure Buttons")
        }
    }
}

@Composable
private fun ControlSwitch(
    title: String,
    checked: Boolean,
    onChange: (Boolean) -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title)
        Switch(
            checked = checked,
            onCheckedChange = onChange
        )
    }
}
