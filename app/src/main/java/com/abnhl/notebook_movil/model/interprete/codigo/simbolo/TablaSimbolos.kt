package com.abnhl.notebook_movil.model.interprete.codigo.simbolo

class TablaSimbolos(var tablaPadre: TablaSimbolos? = null) {
    private val tablaActual: HashMap<String, Simbolo> = HashMap()
    var nombre: String = ""

    constructor() : this(null)

    fun setVariable(simbolo: Simbolo): Boolean {
        val busqueda = tablaActual[simbolo.id]
        if (busqueda == null) {
            tablaActual[simbolo.id] = simbolo
            return true
        }
        return false
    }

    fun getVariable(id: String): Simbolo? {
        var tabla: TablaSimbolos? = this
        while (tabla != null) {
            val busqueda = tabla.tablaActual[id]
            if (busqueda != null) return busqueda
            tabla = tabla.tablaPadre
        }
        return null
    }
}
