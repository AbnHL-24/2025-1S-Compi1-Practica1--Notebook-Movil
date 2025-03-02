package com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.aritmeticos

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.OperacionBinaria
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.OperacionResultante
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.tablas.OperacionesResta
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato

class RestaExpr(
    opIzq: Instruccion,
    opDer: Instruccion,
    linea: Int,
    columna: Int
) : OperacionBinaria(
    opIzq,
    opDer,
    linea,
    columna
)  {
    override fun getTablaOperacion(): Array<Array<TipoDato>> {
        return OperacionesResta.tablaDeRestas
    }

    override fun realizarOperacion(valorIzq: Any?, valorDer: Any?, tipoResult: TipoDato): Any {
        return when(tipoResult) {
            TipoDato.ENTERO -> (valorIzq as Number).toInt() - (valorDer as Number).toInt()
            TipoDato.DECIMAL -> (valorIzq as Number).toDouble() - (valorDer as Number).toDouble()
            else -> Errores(
                "SEMANTICO",
                "Operacion resta entre tipos no compatibles.",
                linea,
                columna
            )
        }
    }
}