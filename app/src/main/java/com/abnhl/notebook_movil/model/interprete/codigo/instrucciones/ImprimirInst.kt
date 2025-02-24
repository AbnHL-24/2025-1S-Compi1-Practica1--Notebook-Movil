package com.abnhl.notebook_movil.model.interprete.codigo.instrucciones

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Arbol
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TablaSimbolos
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Tipo
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato

class ImprimirInst(
    private val expresion: Instruccion,
    linea: Int,
    columna: Int
) : Instruccion(Tipo(TipoDato.VACIO), linea, columna) {
    override fun interpretar(
        arbol: Arbol,
        tablaDeSimbolos: TablaSimbolos
    ): Any? {
        val valor = expresion.interpretar(arbol, tablaDeSimbolos)
        if (valor is Errores) return valor
        arbol.print(valor.toString())
        return null
    }
}