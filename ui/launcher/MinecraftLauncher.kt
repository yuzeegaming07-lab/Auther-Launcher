package com.auther.launcher.ui.launcher

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MinecraftLauncherScreen(
    selectedVersion: String = "Belum dipilih",
    onLaunch: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Minecraft Launcher",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("AUTHER Launcher")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Version: V0.1")
                Text("Minecraft: $selectedVersion")
            }
        }

        Button(
            onClick = onLaunch,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Launch Minecraft")
        }

        Text(
            text = "Status: Runtime belum terhubung",
            color = MaterialTheme.colorScheme.error
        )
    }
}
