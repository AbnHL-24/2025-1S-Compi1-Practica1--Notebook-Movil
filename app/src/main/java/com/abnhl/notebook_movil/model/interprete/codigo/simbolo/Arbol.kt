package com.abnhl.notebook_movil.model.interprete.codigo.simbolo

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import java.util.LinkedList

abstract class Arbol(
    val instrucciones: LinkedList<Instruccion>,
    val consola: String = "",
    val errores: LinkedList<Errores> = LinkedList(),
    val tablaGobal: TablaSimbolos,
    val funciones: LinkedList<Instruccion>
) {

    abstract fun interpretar(
        arbol: Arbol,
        tablaDeSimbolos: TablaSimbolos
    ): Any
}