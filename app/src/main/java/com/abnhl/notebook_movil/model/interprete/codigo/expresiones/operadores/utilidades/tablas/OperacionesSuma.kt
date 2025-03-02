package com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.tablas

import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato

object OperacionesSuma {
    val tablaDeSumas: Array<Array<TipoDato>> = arrayOf(
        //              Entero,           Decimal
        arrayOf(TipoDato.ENTERO, TipoDato.DECIMAL), // Entero
        // Decimal
        arrayOf(TipoDato.DECIMAL, TipoDato.DECIMAL), // Decimal

    )
}