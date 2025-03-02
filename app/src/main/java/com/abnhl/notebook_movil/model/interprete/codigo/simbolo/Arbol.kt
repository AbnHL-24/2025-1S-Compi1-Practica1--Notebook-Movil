package com.abnhl.notebook_movil.model.interprete.codigo.simbolo

import androidx.compose.runtime.mutableStateListOf
import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import java.util.LinkedList

class Arbol(
    val instrucciones: LinkedList<Instruccion>
) {
    val consola: String = ""
    var errores: LinkedList<Errores> = LinkedList()
    var tablaGobal: TablaSimbolos = TablaSimbolos()
    var funciones: LinkedList<Instruccion> = LinkedList()


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
