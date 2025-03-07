package com.abnhl.notebook_movil.model.interprete.codigo.abstracto

import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Arbol
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TablaSimbolos
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Tipo

abstract class Instruccion(
    var tipo: Tipo,
    val linea: Int,
    val columna: Int
) {
    abstract fun interpretar(
        arbol: Arbol,
        tablaDeSimbolos: TablaSimbolos
    ): Any?
}