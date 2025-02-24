package com.abnhl.notebook_movil.model.interprete.codigo.expresiones

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Arbol
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TablaSimbolos
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Tipo

class NativoExpr(
    private val valor: Any,
    tipo: Tipo,
    linea: Int,
    columna: Int
) : Instruccion(tipo, linea, columna) {
    override fun interpretar(
        arbol: Arbol,
        tablaDeSimbolos: TablaSimbolos
    ): Any {
        // TODO: Implementar validaciones para una cadena.
        return valor
    }
}