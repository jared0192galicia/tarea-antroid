package com.example.jetpack_test1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun Form (navController: NavHostController) {

    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var genero by remember { mutableStateOf("Masculino") }
    var mensaje by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {

        Text(
            text = "Formulario de registro",
            style = MaterialTheme.typography.titleLarge
        )
        Text(text = "Nombre")
        TextField(
            value = nombre, onValueChange = {nombre = it}, placeholder = { Text("Imgresa tu nombre")},
            modifier = Modifier.fillMaxWidth()
        )


        Text(text = "Correo electrónico")
        TextField(
            value = email, onValueChange = {email = it}, placeholder = { Text("ejemplo@correo.com")},
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Genero")

        Row (verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = genero == "Masculino", onClick = { genero = "Masculino"})
            Text(text = "Masculino")

            Spacer(modifier = Modifier.width(20.dp))
            RadioButton(selected = genero == "Femenino", onClick = { genero = "Femenino"})
            Text(text = "Femenino")
        }


        Row (verticalAlignment = Alignment.CenterVertically) {

            Button (
                onClick = {mensaje = "Formulario enviado: $nombre, $email, $genero"},
//                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Enviar")
            }

            Button (
                onClick = {navController.navigate("B")},
                // modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Ir a lista de imagenes")
            }

        }

        if (mensaje.isNotEmpty()) {
            Text(text = mensaje, modifier= Modifier.padding(top = 16.dp))
        }

    }
}