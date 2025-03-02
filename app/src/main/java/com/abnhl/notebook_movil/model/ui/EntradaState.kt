package com.abnhl.notebook_movil.model.ui

data class EntradaState(
    val tipoEntrada: TipoEntrada,
    var entrada: String = "",
    var salida: String? = null
)
