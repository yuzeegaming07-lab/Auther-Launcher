
package com.auther.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import com.auther.launcher.ui.home.HomeScreen
import com.auther.launcher.ui.version.VersionScreen
import com.auther.launcher.ui.account.AccountScreen
import com.auther.launcher.ui.skin.SkinScreen
import com.auther.launcher.ui.settings.SettingsScreen
import com.auther.launcher.ui.controls.ControlsScreen
import com.auther.launcher.ui.downloads.DownloadsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AutherLauncherApp()
        }
    }
}

@Composable
fun AutherLauncherApp() {
    var selectedPage by remember {
        mutableStateOf("Home")
    }

    MaterialTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val pages = listOf(
                        "Home",
                        "Versions",
                        "Accounts",
                        "Skins",
                        "Settings",
                        "Controls",
                        "Downloads"
                    )

                    pages.forEach { page ->
                        NavigationBarItem(
                            selected = selectedPage == page,
                            onClick = {
                                selectedPage = page
                            },
                            icon = {
                                Text(
                                    when (page) {
                                        "Home" -> "⌂"
                                        "Versions" -> "V"
                                        "Accounts" -> "A"
                                        "Skins" -> "S"
                                        "Settings" -> "⚙"
                                        "Controls" -> "C"
                                        "Downloads" -> "↓"
                                        else -> "•"
                                    }
                                )
                            },
                            label = {
                                Text(page)
                            }
                        )
                    }
                }
            }
        ) { padding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                when (selectedPage) {
                    "Home" -> HomeScreen(
                        onPlayClick = {},
                        onVersionsClick = {
                            selectedPage = "Versions"
                        },
                        onSettingsClick = {
                            selectedPage = "Settings"
                        }
                    )

                    "Versions" -> VersionScreen(
                        onVersionSelected = {},
                        onInstallClick = {}
                    )

                    "Accounts" -> AccountScreen(
                        onOfflineLogin = {},
                        onElyByLogin = {}
                    )

                    "Skins" -> SkinScreen(
                        onImportSkin = {},
                        onClassicClick = {},
                        onSlimClick = {}
                    )

                    "Settings" -> SettingsScreen()

                    "Controls" -> ControlsScreen()

                    "Downloads" -> DownloadsScreen()
                }
            }
        }
    }
}
