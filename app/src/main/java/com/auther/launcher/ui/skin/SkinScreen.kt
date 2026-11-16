package com.auther.launcher.ui.skin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkinScreen(
    onImportSkin: () -> Unit = {},
    onSelectClassic: () -> Unit = {},
    onSelectSlim: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Skin Manager",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                Text("Skin Preview")
                Text("3D Preview belum terhubung.")
            }
        }

        Button(
            onClick = onImportSkin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Import Skin PNG")
        }

        OutlinedButton(
            onClick = onSelectClassic,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Classic Model (Steve)")
        }

        OutlinedButton(
            onClick = onSelectSlim,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Slim Model (Alex)")
        }
    }
}
