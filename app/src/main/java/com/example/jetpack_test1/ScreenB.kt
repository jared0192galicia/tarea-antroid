package com.example.jetpack_test1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ScreenB(navController: NavHostController) {

    val items = listOf(
        ListItem("https://images.unsplash.com/photo-1507525428034-b723cf961d3e", "Título 1", "Descripción breve del elemento 1."),
        ListItem(stringResource(R.string.image_2), "Título 2", "Descripción breve del elemento 2."),
        ListItem(stringResource(R.string.image_3), "Título 3", "Descripción breve del elemento 3.")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // La lista ocupa el espacio restante, dejando espacio para el botón
        ItemList(items = items, modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("C")
        }) {
            Text(text = "Ir a retrofit", fontSize = 20.sp) // reduce el tamaño si quieres
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}