package com.abnhl.notebook_movil.controller.pruebas

import com.abnhl.notebook_movil.model.analizadores.codigo.CodeLexer
import com.abnhl.notebook_movil.model.analizadores.codigo.CodeParser
import com.abnhl.notebook_movil.model.interprete.codigo.abstracto.Instruccion
import com.abnhl.notebook_movil.model.interprete.codigo.excepciones.Errores
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.Arbol
import com.abnhl.notebook_movil.model.interprete.codigo.simbolo.TablaSimbolos
import java.io.StringReader
import java.util.LinkedList

class CodePruebas {
    val listaErrores: LinkedList<Errores> = LinkedList()

    fun ejecutar(entrada: String) : String {
        val codeLexer = CodeLexer(StringReader(entrada))
        val codeParser = CodeParser(codeLexer)
        val result = codeParser.parse()

        listaErrores.addAll(codeLexer.erroresCodeLexer)

        var ast = Arbol(result.value as LinkedList<Instruccion>)
        var tabla = TablaSimbolos()
        ast.tablaGobal = tabla

        for (a in ast.instrucciones) {
            /*var res = a.interpretar(ast, tabla)
            if ()*/
            if (a is Instruccion) ast.agregarFunciones(a)
        }
        listaErrores.addAll(ast.errores)
        return ast.consola
    }
}