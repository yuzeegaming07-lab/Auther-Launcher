package com.auther.launcher.ui.account

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountScreen(
    onOfflineLogin: (String) -> Unit = {},
    onElyByLogin: () -> Unit = {}
) {
    var username by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Accounts",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Offline Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (username.isNotBlank()) {
                    onOfflineLogin(username.trim())
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login Offline")
        }

        OutlinedButton(
            onClick = onElyByLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login with Ely.by")
        }

        Text("Microsoft login tidak disediakan.")
    }
}
