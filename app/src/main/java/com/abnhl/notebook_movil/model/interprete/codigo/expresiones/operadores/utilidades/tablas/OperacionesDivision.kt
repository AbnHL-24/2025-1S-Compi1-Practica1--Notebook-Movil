package com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.tablas

import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato

object OperacionesDivision {
    val tablaDeDivisiones: Array<Array<TipoDato>> = arrayOf(
        //              Entero,           Decimal
        arrayOf(TipoDato.DECIMAL, TipoDato.DECIMAL), // Entero
        // Decimal
        arrayOf(TipoDato.DECIMAL, TipoDato.DECIMAL), // Decimal

    )
}