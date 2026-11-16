package com.auther.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Bg = Color(0xFF0B1020)
private val Panel = Color(0xFF151D32)
private val Accent = Color(0xFF7C5CFC)
private val Muted = Color(0xFF9AA7C2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AutherApp()
        }
    }
}

@Composable
fun AutherApp() {
    var page by remember { mutableStateOf("Home") }

    MaterialTheme(
        colorScheme = darkColorScheme(
            background = Bg,
            surface = Panel,
            primary = Accent,
            onBackground = Color.White,
            onSurface = Color.White
        )
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .background(Bg)
        ) {
            NavigationRail(
                containerColor = Panel
            ) {
                listOf(
                    "Home",
                    "Versions",
                    "Downloads",
                    "Skins",
                    "Accounts",
                    "Settings"
                ).forEach { item ->

                    NavigationRailItem(
                        selected = page == item,
                        onClick = { page = item },
                        icon = {
                            Icon(
                                imageVector = when (item) {
                                    "Home" -> Icons.Default.Home
                                    "Versions" -> Icons.Default.Extension
                                    "Downloads" -> Icons.Default.Download
                                    "Skins" -> Icons.Default.Person
                                    "Accounts" -> Icons.Default.AccountCircle
                                    else -> Icons.Default.Settings
                                },
                                contentDescription = item
                            )
                        },
                        label = {
                            Text(item, fontSize = 9.sp)
                        }
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {
                Text(
                    "AUTHER",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    "MINECRAFT JAVA LAUNCHER • V0.1",
                    color = Muted,
                    fontSize = 10.sp
                )

                Spacer(Modifier.height(20.dp))

                when (page) {
                    "Home" -> HomeScreen()
                    "Versions" -> VersionsScreen()
                    "Downloads" -> DownloadsScreen()
                    "Skins" -> SkinsScreen()
                    "Accounts" -> AccountsScreen()
                    else -> SettingsScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Panel
                ),
                shape = RoundedCornerShape(22.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text("Welcome back", color = Muted)

                    Text(
                        "Ready to play?",
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Selected instance: Vanilla • 1.20.1",
                        color = Muted
                    )

                    Spacer(Modifier.height(18.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.PlayArrow, null)
                        Spacer(Modifier.width(8.dp))
                        Text("PLAY")
                    }

                    Text(
                        "Minecraft runtime is not connected yet.",
                        color = Muted,
                        fontSize = 11.sp
                    )
                }
            }
        }

        item {
            FeatureCard(
                "Quick access",
                "Versions • Mods • Shaders • Resource Packs • Worlds"
            )
        }

        item {
            FeatureCard(
                "Launcher status",
                "AUTHER Launcher V0.1 • Development build"
            )
        }
    }
}

@Composable
fun VersionsScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Version & Loader", fontSize = 22.sp)

        listOf(
            "Vanilla",
            "Fabric",
            "Forge",
            "NeoForge",
            "Quilt"
        ).forEach {
            FeatureCard(
                it,
                "Instance manager • Installation pending"
            )
        }

        Button(onClick = {}) {
            Text("Add instance")
        }
    }
}

@Composable
fun DownloadsScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Downloads", fontSize = 22.sp)

        listOf(
            "Mods",
            "Shaders",
            "Resource Packs",
            "Worlds",
            "Installer"
        ).forEach {
            FeatureCard(
                it,
                "Browse and import • Modrinth integration pending"
            )
        }
    }
}

@Composable
fun SkinsScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Skin Manager", fontSize = 22.sp)

        FeatureCard(
            "Skin Preview",
            "3D preview component planned"
        )

        FeatureCard(
            "Player Model",
            "Classic (Steve) / Slim (Alex)"
        )

        Button(onClick = {}) {
            Text("Import PNG Skin")
        }
    }
}

@Composable
fun AccountsScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Accounts", fontSize = 22.sp)

        FeatureCard(
            "Offline Account",
            "Local player profile"
        )

        FeatureCard(
            "Ely.by",
            "Authentication integration pending"
        )
    }
}

@Composable
fun SettingsScreen() {

    var mouseSensitivity by remember {
        mutableFloatStateOf(0.5f)
    }

    var guiScale by remember {
        mutableFloatStateOf(2f)
    }

    var invertMouse by remember {
        mutableStateOf(false)
    }

    var mouseCapture by remember {
        mutableStateOf(true)
    }

    var touchControls by remember {
        mutableStateOf(true)
    }

    var joystick by remember {
        mutableStateOf(true)
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Settings", fontSize = 22.sp)
        }

        item {
            SettingGroup("GUI & Display") {
                SliderSetting(
                    "GUI Scale",
                    guiScale,
                    1f,
                    4f
                ) { guiScale = it }

                Text(
                    "Scale: ${guiScale.toInt()}",
                    color = Muted
                )
            }
        }

        item {
            SettingGroup("Mouse Control") {
                SliderSetting(
                    "Mouse Sensitivity",
                    mouseSensitivity,
                    0f,
                    1f
                ) { mouseSensitivity = it }

                SwitchSetting(
                    "Invert Mouse",
                    invertMouse
                ) { invertMouse = it }

                SwitchSetting(
                    "Mouse Capture",
                    mouseCapture
                ) { mouseCapture = it }
            }
        }

        item {
            SettingGroup("Touch & Input") {
                SwitchSetting(
                    "Touch Controls",
                    touchControls
                ) { touchControls = it }

                SwitchSetting(
                    "On-screen Joystick",
                    joystick
                ) { joystick = it }

                FeatureCard(
                    "Button Mapping",
                    "Custom key mapping planned"
                )

                FeatureCard(
                    "Keyboard & Mouse",
                    "USB / Bluetooth support planned"
                )
            }
        }

        item {
            SettingGroup("Java & Performance") {
                FeatureCard(
                    "Java Runtime",
                    "Runtime selection planned"
                )

                FeatureCard(
                    "Memory / RAM",
                    "Minimum and maximum heap settings planned"
                )

                FeatureCard(
                    "Renderer",
                    "Renderer compatibility planned"
                )

                FeatureCard(
                    "Video",
                    "Resolution, FPS and VSync planned"
                )
            }
        }

        item {
            SettingGroup("Other") {
                FeatureCard("Audio", "Volume settings planned")
                FeatureCard("Storage", "Game directory planned")
                FeatureCard("About", "AUTHER Launcher V0.1")
            }
        }
    }
}

@Composable
fun FeatureCard(
    title: String,
    subtitle: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Panel
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(Modifier.height(4.dp))

            Text(
                subtitle,
                color = Muted,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun SettingGroup(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Panel
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB9A9FF)
            )

            content()
        }
    }
}

@Composable
fun SwitchSetting(
    title: String,
    checked: Boolean,
    onChecked: (Boolean) -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title,
            Modifier.weight(1f)
        )

        Switch(
            checked = checked,
            onCheckedChange = onChecked
        )
    }
}

@Composable
fun SliderSetting(
    title: String,
    value: Float,
    min: Float,
    max: Float,
    onValue: (Float) -> Unit
) {
    Column {
        Text(title)

        Slider(
            value = value,
            onValueChange = onValue,
            valueRange = min..max
        )
    }
}
