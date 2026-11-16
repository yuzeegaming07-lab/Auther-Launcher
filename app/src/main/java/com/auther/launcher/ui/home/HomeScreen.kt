package com.auther.launcher.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.auther.launcher.ui.components.FeatureCard

@Composable
fun HomeScreen(
    onPlayClick: () -> Unit = {},
    onVersionsClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "AUTHER Launcher",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Minecraft Java Edition")
        Text("Version V0.1")

        Button(
            onClick = onPlayClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("PLAY MINECRAFT")
        }

        FeatureCard(
            "Versions",
            "Manage Minecraft versions",
            onVersionsClick
        )

        FeatureCard(
            "Settings",
            "Configure your launcher",
            onSettingsClick
        )
    }
}
