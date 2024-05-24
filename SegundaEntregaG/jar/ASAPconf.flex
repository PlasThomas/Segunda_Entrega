package ASAP;
import java_cup.runtime.Symbol;
import java.io.*;
%%
%{
    public int getYyline() {
            return yyline;
        }

    public int getYy_currentPos() {
        return yy_currentPos-1;
    }
%}
%class LexicoASAP
%public
%char
%line
%column
%cup
DIGITO = [0-9]
LETRA = [a-zA-Z_]
ID = {LETRA}({LETRA}|{DIGITO})*
%%
"var"             { return new Symbol(sym.VAR, yyline, yycolumn, yytext()); }
"integer"         { return new Symbol(sym.INTEGER, yyline, yycolumn, yytext()); }
"boolean"         { return new Symbol(sym.BOOLEAN, yyline, yycolumn, yytext()); }
{ID}              { return new Symbol(sym.ID, yyline, yycolumn, yytext()); }
":"               { return new Symbol(sym.DOSP, yyline, yycolumn, yytext()); }
";"               { return new Symbol(sym.PYCOMA, yyline, yycolumn, yytext()); }
","               { return new Symbol(sym.COMA, yyline, yycolumn, yytext()); }
[ \t\n\r]+       { }
[\s]+            { /* Ignorar espacios en blanco */ }
.                 { System.err.println("Caracter invalido: " + yytext() + " en linea " + (yyline + 1) + ", columna " + yycolumn); }