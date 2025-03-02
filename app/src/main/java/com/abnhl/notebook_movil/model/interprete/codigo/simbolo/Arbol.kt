package com.abnhl.notebook_movil.model.interprete.codigo.simbolo

import androidx.compose.runtime.mutableStateListOf
import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import java.util.LinkedList

class Arbol(
    val instrucciones: MutableList<Instruccion> = mutableStateListOf(),
    private val consola: String = "",
    val errores: MutableList<Errores> = mutableListOf(),
    val tablaGobal: TablaSimbolos,
    val funciones: MutableList<Instruccion> = mutableListOf()
) {
    fun print(valor: String) {
        this.consola.plus(valor)
    }

    fun agregarErrores(Error: Errores) {
        this.errores.add(Error)
    }

    fun agregarFunciones(funcion: Instruccion) {
        this.funciones.add(funcion)
    }
}
