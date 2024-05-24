package Programas;
import java.io.*;
import static Programas.BnfsTokens.*;
%%
%class Lexico
%type BnfsTokens
WHITE = [\t\r\n]
%{
    public String lexema;
%}
%%
{WHITE} {/* NO HACE NADA */}
" " {}
"or" {return OR;}
"and" {return AND;}
"not" {return NOT;}
")" {return CPARENTESIS;}
"(" {return APARENTESIS;}
"true" {return TRUE;}
"false" {return FALSE;}
";" {return PUNTOYCOMA;}
. {return ERROR;}