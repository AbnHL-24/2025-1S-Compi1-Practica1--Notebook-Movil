package com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades

import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato

object OperacionResultante {
    fun calcular(
        tablaTipos: Array<Array<TipoDato>>,
        indexIzq: Int,
        indexDer: Int
    ): TipoDato {
        if (indexIzq >= tablaTipos.size || indexDer >= tablaTipos.size) {
            return TipoDato.VACIO
        }
        return tablaTipos[indexIzq][indexDer]
    }
}