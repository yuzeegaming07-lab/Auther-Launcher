package com.auther.launcher.ui.launcher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InstanceManagerScreen(
    instances: List<String> = listOf("Default"),
    onCreateInstance: (String) -> Unit = {},
    onSelectInstance: (String) -> Unit = {}
) {
    var instanceName by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Instance Manager",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = instanceName,
            onValueChange = { instanceName = it },
            label = { Text("Instance Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (instanceName.isNotBlank()) {
                    onCreateInstance(instanceName.trim())
                    instanceName = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Instance")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Your Instances")

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(instances) { instance ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSelectInstance(instance) }
                ) {
                    Text(
                        instance,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
