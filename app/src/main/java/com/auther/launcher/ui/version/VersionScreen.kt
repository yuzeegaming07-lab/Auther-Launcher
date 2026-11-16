package com.auther.launcher.ui.version

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VersionScreen(
    versions: List<String> = listOf(
        "1.21.1",
        "1.20.1",
        "1.19.4",
        "1.18.2",
        "1.16.5"
    ),
    onVersionSelected: (String) -> Unit = {},
    onInstallClick: () -> Unit = {}
) {
    Column(
        Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            "Version Manager",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = onInstallClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Install Version")
        }

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(versions) { version ->
                Card(
                    Modifier
                        .fillMaxWidth()
                        .clickable { onVersionSelected(version) }
                ) {
                    Text(
                        "Minecraft $version",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
