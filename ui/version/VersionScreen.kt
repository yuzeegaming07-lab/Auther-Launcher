package com.auther.launcher.ui.version

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VersionScreen(
    onInstall: (String) -> Unit = {}
) {
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Version & Loader", fontSize = 24.sp)

        listOf(
            "Vanilla",
            "Fabric",
            "Forge",
            "NeoForge",
            "Quilt"
        ).forEach { loader ->
            Card {
                Row(
                    Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(loader)
                    TextButton(onClick = { onInstall(loader) }) {
                        Text("Install")
                    }
                }
            }
        }
    }
}
