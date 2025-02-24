package com.abnhl.notebook_movil.model.interprete.codigo.simbolo

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import java.util.LinkedList

class Arbol(
    val instrucciones: LinkedList<Instruccion>,
    private val consola: String = "",
    val errores: LinkedList<Errores> = LinkedList(),
    val tablaGobal: TablaSimbolos,
    val funciones: LinkedList<Instruccion>
) {
    fun print(valor: String) {
        this.consola.plus(valor)
    }
}