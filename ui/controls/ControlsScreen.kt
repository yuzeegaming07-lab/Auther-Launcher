package com.auther.launcher.ui.controls

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControlsScreen() {
    var joystick by remember { mutableStateOf(true) }
    var mouseCapture by remember { mutableStateOf(true) }
    var touch by remember { mutableStateOf(true) }

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Controls", fontSize = 24.sp)

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("On-screen Joystick")
            Switch(joystick, { joystick = it })
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Mouse Capture")
            Switch(mouseCapture, { mouseCapture = it })
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Touch Controls")
            Switch(touch, { touch = it })
        }

        Text("Keyboard & Mouse")
        Text("Button Mapping")
        Text("Mouse Sensitivity")
    }
}
