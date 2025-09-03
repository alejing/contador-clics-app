package com.example.contadordeclics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contadordeclics.ui.theme.ContadorDeClicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorDeClicsTheme { // El tema de tu app
                CounterScreenStateful()
            }
        }
    }
}

@Composable
fun CounterScreenStateful() {
    // Declara el estado
    // remember() es crucial para que el valor se mantenga a lo largo de las recomposiciones.
    // mutableStateOf(0) crea un objeto que podemos observar para los cambios.
    var count by remember { mutableIntStateOf(0) }

    // La UI que muestra el estado y permite la interacción
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        // Muestra el valor del estado en un Text
        Text(
            text = "Has pulsado $count veces",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Un botón para cambiar el estado.
        Button(onClick = {
            // Al hacer clic, se actualiza la variable 'count'
            // Esto provoca una "recomposición" del componente,
            // haciendo que la UI se actualice.
            count++
        }) {
            Text(text = "Pulsa aquí")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenStatefulPreview() {
    ContadorDeClicsTheme {
        CounterScreenStateful()
    }
}