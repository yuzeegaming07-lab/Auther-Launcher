package com.auther.launcher.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun AutherButton(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text)
    }
}
