package com.auther.launcher.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onPlay: () -> Unit = {},
    selectedVersion: String = "Vanilla 1.20.1"
) {
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Welcome to AUTHER", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text("Minecraft Java Launcher • V0.1", color = Color.Gray)

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF151D32)
            )
        ) {
            Column(Modifier.fillMaxWidth().padding(20.dp)) {
                Text("Selected Version", color = Color.LightGray)
                Text(selectedVersion, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(20.dp))
                Button(onClick = onPlay, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.Default.PlayArrow, null)
                    Text(" PLAY")
                }
            }
        }

        Text("Quick Access", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Versions • Mods • Shaders • Resource Packs • Worlds")
    }
}
