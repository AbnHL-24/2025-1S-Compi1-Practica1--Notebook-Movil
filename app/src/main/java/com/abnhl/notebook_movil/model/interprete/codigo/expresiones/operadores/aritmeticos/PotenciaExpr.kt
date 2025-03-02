package com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.aritmeticos

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.OperacionBinaria
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.tablas.OperacionesPotenciacion
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.tablas.OperacionesSuma
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato
import kotlin.math.pow

class PotenciaExpr(
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
        return OperacionesPotenciacion.tablaDePotencias
    }

    override fun realizarOperacion(valorIzq: Any?, valorDer: Any?, tipoResult: TipoDato): Any {
        return when (tipoResult) {
            TipoDato.ENTERO -> (valorIzq as Number).toDouble().pow((valorDer as Number).toDouble())
                .toInt()

            TipoDato.DECIMAL -> (valorIzq as Number).toDouble().pow((valorDer as Number).toDouble())
            else -> Errores(
                "SEMANTICO",
                "Operacion potencia entre tipos no compatibles.",
                linea,
                columna
            )
        }
    }
}