package com.auther.launcher.ui.downloads

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DownloadsScreen(
    onVersions: () -> Unit = {},
    onMods: () -> Unit = {},
    onShaders: () -> Unit = {},
    onResourcePacks: () -> Unit = {},
    onWorlds: () -> Unit = {},
    onInstaller: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Downloads",
            style = MaterialTheme.typography.headlineMedium
        )

        DownloadButton("Versions & Loader", onVersions)
        DownloadButton("Mods", onMods)
        DownloadButton("Shaders", onShaders)
        DownloadButton("Resource Packs", onResourcePacks)
        DownloadButton("Worlds", onWorlds)
        DownloadButton("Installer", onInstaller)
    }
}

@Composable
private fun DownloadButton(
    title: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(title)
    }
}
