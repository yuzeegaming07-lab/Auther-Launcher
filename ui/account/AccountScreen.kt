package com.auther.launcher.ui.account

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountScreen(
    onOfflineLogin: (String) -> Unit = {},
    onElyByLogin: () -> Unit = {}
) {
    var nickname by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Accounts", fontSize = 24.sp)

        OutlinedTextField(
            value = nickname,
            onValueChange = { nickname = it },
            label = { Text("Offline Nickname") }
        )

        Button(
            onClick = { onOfflineLogin(nickname) },
            enabled = nickname.isNotBlank()
        ) {
            Text("Offline Login")
        }

        OutlinedButton(onClick = onElyByLogin) {
            Text("Ely.by Login")
        }
    }
}
