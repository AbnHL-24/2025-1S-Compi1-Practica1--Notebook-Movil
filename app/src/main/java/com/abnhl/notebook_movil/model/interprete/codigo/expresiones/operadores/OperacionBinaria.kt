package com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores

import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import com.abnhl.notebook_movil.model.interprete.codigo.expresiones.operadores.utilidades.OperacionResultante
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Arbol
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TablaSimbolos
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Tipo
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TipoDato

abstract class OperacionBinaria(
    private val opIzq: Instruccion,
    private val opDer: Instruccion,
    linea: Int,
    columna: Int
) : Instruccion(
    Tipo(TipoDato.VACIO), linea, columna
) {
    override fun interpretar(arbol: Arbol, tablaDeSimbolos: TablaSimbolos): Any? {
        // Se interpretan los operadores.
        val valorIzq = opIzq.interpretar(arbol, tablaDeSimbolos)
        val valorDer = opDer.interpretar(arbol, tablaDeSimbolos)

        // Se verifica si los operadores son errores.
        if (valorIzq is Errores || valorDer is Errores)
            return when {
                valorIzq is Errores -> valorIzq
                else -> valorDer
            }

        var tipoResult = OperacionResultante.calcular(getTablaOperacion(),
            opIzq.tipo.tipoDato.ordinal,
            opDer.tipo.tipoDato.ordinal
        )

        this.tipo.tipoDato = tipoResult

        return realizarOperacion(valorIzq, valorDer, tipoResult)
    }

    protected abstract fun getTablaOperacion(): Array<Array<TipoDato>>;

    protected abstract fun realizarOperacion(valorIzq: Any?, valorDer: Any?, tipoResult: TipoDato): Any;
}