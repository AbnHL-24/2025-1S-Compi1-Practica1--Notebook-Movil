package com.abnhl.notebook_movil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abnhl.notebook_movil.ui.TipoEntrada
import com.abnhl.notebook_movil.ui.theme._20251SCompi1Practica1NotebookMovilTheme

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
//@Preview
@Composable
fun ViewContainer(InnerPadding: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Notebook Móvil") },

                )
        },
    ) { innerPadding ->
        GestionDeEntradas(Modifier.padding(innerPadding))
    }
}

@Preview
@Composable
fun GestionDeEntradas(modifier: Modifier = Modifier) {
    var entradas = rememberSaveable { mutableStateListOf<@Composable () -> Unit>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
            item {
                ElevatedButton(onClick = {
                    entradas.add {
                        Entrada(
                            TipoEntrada.TEXTO,
                            modifier
                        )
                    }
                }) { Text("Texto") }
            }
            item {
                ElevatedButton(onClick = {
                    entradas.add {
                        Entrada(
                            TipoEntrada.CODIGO,
                            modifier
                        )
                    }
                }) { Text("Código") }
            }
        }
        LazyColumn {
            items(entradas) { entrada ->
                entrada()
            }
        }
    }
}

@Composable
fun Entrada(tipoEntrada: TipoEntrada, modifier: Modifier = Modifier) {

}

@Preview
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