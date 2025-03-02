package com.abnhl.notebook_movil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abnhl.notebook_movil.controller.pruebas.CodePruebas
import com.abnhl.notebook_movil.model.ui.TipoEntrada
import com.abnhl.notebook_movil.ui.theme._20251SCompi1Practica1NotebookMovilTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _20251SCompi1Practica1NotebookMovilTheme {
                ViewContainer()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ViewContainer(/*InnerPadding: Modifier = Modifier*/) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Notebook Móvil") },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            GestionDeEntradas(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun GestionDeEntradas(modifier: Modifier = Modifier) {

    var entrada by remember { mutableStateOf("") }
    var salida by remember { mutableStateOf("") }
    val codePruebas = CodePruebas()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            LazyRow(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                item {
                    ElevatedButton(onClick = {
                        //elementos.add(TipoEntrada.TEXTO)  // Guardamos solo el tipo de entrada
                    }) { Text("Ejecutar texto") }
                }

                item {
                    ElevatedButton(onClick = {
                        //elementos.add(TipoEntrada.CODIGO)
                        codePruebas.ejecutar(entrada)
                    }) { Text("Ejecutar código") }
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
        }
        item {
            OutlinedTextField(
                value = entrada,
                onValueChange = { entrada = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Ingrese su código") },
                maxLines = Int.MAX_VALUE
            )
        }
        item {
            Spacer(modifier = Modifier.height(2.dp))
        }
        item {
            //Text(text = salida)
            Card(
                modifier = Modifier
                    .fillMaxSize()
            ) { Text(modifier = Modifier.padding(5.dp), text = salida) }
        }
    }

}

@Composable
fun Entrada(tipoEntrada: TipoEntrada, modifier: Modifier = Modifier) {
    var entrada by remember { mutableStateOf("") }
    var salida by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) // Añade un borde para visualizar
            .padding(8.dp)
    ) {
        // Entrada de texto.
        OutlinedTextField(
            value = entrada,
            onValueChange = { entrada = it },
            modifier = modifier
                .fillMaxSize(),
            //.defaultMinSize(minHeight = 56.dp), // Altura minima.
            placeholder = {
                Text(
                    "Ingrese su ${
                        tipoEntrada.toString().lowercase(Locale.getDefault())
                    }"
                )
            },
            maxLines = Int.MAX_VALUE,
            keyboardOptions = KeyboardOptions.Default,
            //shape = RoundedCornerShape(8.dp)
        )
        Button(
            onClick = { salida = "Resultado: $entrada" },
            modifier = Modifier.align(Alignment.End)
        ) { Text("Ejecutar") }
        // Salida del resultado.
        salida.let {
            Spacer(modifier = Modifier.padding(8.dp))
            it?.let { it1 ->
                OutlinedTextField(
                    value = it1,
                    onValueChange = {},
                    modifier = modifier.fillMaxWidth(),
                    readOnly = true,
                    //shape = RoundedCornerShape(8.dp),
                    maxLines = Int.MAX_VALUE
                )
            }
        }
    }
}

//@Preview
@Composable
fun EntradaPreview() {
    Entrada(TipoEntrada.TEXTO)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun ViewContainerPreview() {
    _20251SCompi1Practica1NotebookMovilTheme {
        ViewContainer()
    }
}