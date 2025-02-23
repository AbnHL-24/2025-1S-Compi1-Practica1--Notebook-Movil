package com.abnhl.notebook_movil.model.analizadores.codigo;

// Importaciones.
import java_cup.runtime.*;
import java.util.LinkedList;

%%
// Código de usuario, de ser necesario.
%{
    //public LinkedList<ErroresExpresiones> erroresCodeLexer = LinkedList<ErroresExpresiones>();
%}

%init{
yyline = 1;
yycolumn = 1;
erroresCodeLexer = new LinkedList<>();
%init}

// Definiciones de las caracteristicas de JFlex.
%cup // Indica que se utilizará CUP.
%class CodeLexer // Nombre de la clase.
%public // Indica que la clase es pública.
%line // Se utiliza para llevar el control de las líneas.
%column // Se utiliza para llevar el control de las columnas.
%char // Se utiliza para llevar el control de los caracteres.
%full // Se utiliza para llevar el control de los caracteres completos.
%debug // Se utiliza para llevar el control de los errores.
//%ignorecase // Se utiliza para ignorar las mayúsculas y minúsculas.


// Palabras reservadas.
PRINT = "print" // Imprimir.
FORMAT = "format" // Formatear.
PLOT = "plot" // Graficar.
REPORTES = "reportes" // Reportes.
OPERADORES = "operadores" // Operadores.
ERRORES = "errores" // Errores.

// Simbolos del lenguaje.
ID = [a-zA-Z][a-zA-Z0-9_]* // Identificador.
CADENA = [\"]((\\\")|[^\"\n]*)[\"] // Cadena de texto.
//CARACTER = [']([^'\n])['] // Caracter.
DECIMAL = [0-9]+"."[0-9]+ // Decimal.
ENTERO = [0-9]+ // Entero.
MAS = "+" // Suma.
MENOS = "-" // Resta.
MULT = "*" // Multiplicación.
DIV = "/" // División.
POW = "^" // Potencia.
ASIGNACION = "=" // Asignación.
PARENT_IZQ = "(" // Parentesis izquierdo.
PARENT_DER = ")" // Parentesis derecho.
PUNTO = "." // Punto.


%%
// Aquí importa el orden.
// Palabras y simbolos van primero.
<YYINITIAL> {PRINT} { return new Symbol(sym.PRINT, yyline, yycolumn, yytext()); }
<YYINITIAL> {FORMAT} { return new Symbol(sym.FORMAT, yyline, yycolumn, yytext()); }
<YYINITIAL> {PLOT} { return new Symbol(sym.PLOT, yyline, yycolumn, yytext()); }
<YYINITIAL> {REPORTES} { return new Symbol(sym.REPORTES, yyline, yycolumn, yytext()); }
<YYINITIAL> {OPERADORES} { return new Symbol(sym.OPERADORES, yyline, yycolumn, yytext()); }
<YYINITIAL> {ERRORES} { return new Symbol(sym.ERRORES, yyline, yycolumn, yytext()); }
// Simbolos.
<YYINITIAL> {ID} { return new Symbol(sym.ID, yyline, yycolumn, yytext()); }
<YYINITIAL> {CADENA} { return new Symbol(sym.CADENA, yyline, yycolumn, yytext()); }
<YYINITIAL> {DECIMAL} { return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext()); }
<YYINITIAL> {ENTERO} { return new Symbol(sym.ENTERO, yyline, yycolumn, yytext()); }
<YYINITIAL> {MAS} { return new Symbol(sym.MAS, yyline, yycolumn, yytext()); }
<YYINITIAL> {MENOS} { return new Symbol(sym.MENOS, yyline, yycolumn, yytext()); }
<YYINITIAL> {MULT} { return new Symbol(sym.MULT, yyline, yycolumn, yytext()); }
<YYINITIAL> {DIV} { return new Symbol(sym.DIV, yyline, yycolumn, yytext()); }
<YYINITIAL> {POW} { return new Symbol(sym.POW, yyline, yycolumn, yytext()); }
<YYINITIAL> {ASIGNACION} { return new Symbol(sym.ASIGNACION, yyline, yycolumn, yytext()); }
<YYINITIAL> {PARENT_IZQ} { return new Symbol(sym.PARENT_IZQ, yyline, yycolumn, yytext()); }
<YYINITIAL> {PARENT_DER} { return new Symbol(sym.PARENT_DER, yyline, yycolumn, yytext()); }
<YYINITIAL> {PUNTO} { return new Symbol(sym.PUNTO, yyline, yycolumn, yytext()); }

// Errores lexicos.
/*<YYINITIAL> . {erroresLexicos.add(new ErroresExpresiones("LEXICO",
                "El caracter " +yytext()+" no pertenece al lenguaje",
                yyline, yycolumn));}*/
