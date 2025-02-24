package com.abnhl.notebook_movil.model.interprete.codigo.excepciones

class Errores(
    val tipo: String,
    val descripcion: String,
    val linea: Int,
    val columna: Int
) {
}