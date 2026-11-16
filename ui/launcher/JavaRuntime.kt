package com.auther.launcher.ui.launcher

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun JavaRuntimeScreen(
    javaVersion: String = "Belum terdeteksi",
    runtimePath: String = "Belum dipilih",
    onSelectRuntime: () -> Unit = {},
    onCheckRuntime: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Java Runtime",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Java Version")
                Text(
                    javaVersion,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text("Runtime Path")
                Text(runtimePath)
            }
        }

        Button(
            onClick = onSelectRuntime,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Java Runtime")
        }

        OutlinedButton(
            onClick = onCheckRuntime,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Check Runtime")
        }

        Text(
            "Java Runtime belum otomatis terpasang. " +
                "Fitur ini masih menunggu integrasi runtime Android."
        )
    }
}
