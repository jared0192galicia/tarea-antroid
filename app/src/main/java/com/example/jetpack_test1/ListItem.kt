package com.example.jetpack_test1

// Imports necesarios
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Modelo de datos para cada elemento de la lista
data class ListItem(
    val imageRes: Int,
    val title: String,
    val description: String
)

// Lista de ejemplo
val _sampleItems = listOf(
    ListItem(R.drawable.ic_launcher_foreground, "Título 1", "Descripción breve del elemento 1."),
    ListItem(R.drawable.ic_launcher_foreground, "Título 2", "Descripción breve del elemento 2."),
    ListItem(R.drawable.ic_launcher_foreground, "Título 3", "Descripción breve del elemento 3.")
)

// Composable principal para mostrar la lista
@Composable
fun ItemList(items: List<ListItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            ListItemCard(item)
        }
    }
}

// Composable para cada elemento individual
@Composable
fun ListItemCard(item: ListItem) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 8.dp)
            )

            // Título y descripción
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = item.description,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }
    }
}