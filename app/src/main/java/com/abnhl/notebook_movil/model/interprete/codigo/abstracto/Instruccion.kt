package com.abnhl.notebook_movil.model.interprete.codigo.abstracto

import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Tipo

abstract class Instruccion(
    val tipo: Tipo,
    val linea: Int,
    val columna: Int
) {
}