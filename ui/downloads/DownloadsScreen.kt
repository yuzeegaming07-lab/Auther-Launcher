package com.auther.launcher.ui.downloads

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DownloadsScreen(
    onOpenCategory: (String) -> Unit = {}
) {
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Downloads", fontSize = 24.sp)

        listOf(
            "Mods",
            "Shaders",
            "Resource Packs",
            "Worlds",
            "Installer"
        ).forEach { category ->
            Card {
                Row(
                    Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(category)
                    TextButton(onClick = { onOpenCategory(category) }) {
                        Text("Open")
                    }
                }
            }
        }
    }
}
