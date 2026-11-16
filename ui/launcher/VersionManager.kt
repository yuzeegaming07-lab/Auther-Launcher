package com.auther.launcher.ui.launcher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VersionManagerScreen(
    versions: List<String> = listOf(
        "Release 1.20.1",
        "Release 1.19.4",
        "Release 1.18.2",
        "Release 1.16.5"
    ),
    onVersionSelected: (String) -> Unit = {},
    onInstallVersion: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Version Manager",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onInstallVersion,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Install Version")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(versions) { version ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onVersionSelected(version) }
                ) {
                    Text(
                        text = version,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
