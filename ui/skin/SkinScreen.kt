package com.auther.launcher.ui.skin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkinScreen(
    onImportSkin: () -> Unit = {}
) {
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Skin Manager", fontSize = 24.sp)

        Card {
            Column(Modifier.fillMaxWidth().padding(20.dp)) {
                Text("3D Skin Preview")
                Text("Steve / Alex")
            }
        }

        Button(onClick = onImportSkin) {
            Text("Import PNG Skin")
        }
    }
}
