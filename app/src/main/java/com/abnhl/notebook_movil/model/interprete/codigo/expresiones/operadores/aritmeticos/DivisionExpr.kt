package com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.aritmeticos

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.OperacionBinaria
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.tablas.OperacionesDivision
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato

class DivisionExpr (
    opIzq: Instruccion,
    opDer: Instruccion,
    linea: Int,
    columna: Int
) : OperacionBinaria(
    opIzq,
    opDer,
    linea,
    columna
) {
    override fun getTablaOperacion(): Array<Array<TipoDato>> {
        return OperacionesDivision.tablaDeDivisiones
    }

    override fun realizarOperacion(valorIzq: Any?, valorDer: Any?, tipoResult: TipoDato): Any {
        if (valorDer.toString().toDouble() == 0.0) {
            return Errores(
                "SEMANTICO",
                "La division entre 0 es indefinida",
                linea,
                columna
            )
        }

        return when (tipoResult) {
            TipoDato.ENTERO -> (valorIzq as Number).toDouble() / (valorDer as Number).toDouble()
            TipoDato.DECIMAL -> (valorIzq as Number).toDouble() / (valorDer as Number).toDouble()
            else -> Errores(
                "SEMANTICO",
                "Operacion division entre tipos no compatibles.",
                linea,
                columna
            )
        }
    }
}