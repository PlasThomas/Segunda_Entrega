package Programas;

import java.io.*;
import java.util.ArrayList;

public class BnfRec {
    private FileReader archivo;
    private ArrayList<String> pilaError = new ArrayList<String>();
    private boolean fintext = false;
    private int primerToken = 0;
    private Lexico lexico;
    private BnfsTokens token;
    private ArrayList<String> out = new ArrayList<String>();

    public void setArchivo(String file) throws FileNotFoundException {
        archivo = new FileReader(file);
    }

    public ArrayList<String> task() throws IOException {
        out.clear();
        Reader rd = new BufferedReader(archivo);
        lexico = new Lexico(rd);
        do{
            S();
            primerToken = 0;
            if(fintext)
                out.add("Fin del Archivo");
            else if(pilaError.isEmpty())
                out.add("Cadena valida \n");
            else {
                out.add("Cadena invalida");
                out.addAll(pilaError);
                out.add("\n");
            }
            pilaError.clear();
        }while(token != null);
        return out;
    }

    /*
     E-> T or E | T
     T-> F and T | F
     F-> not F | true | false | ( E )
     */
    public void S() throws IOException {
        out.add("S");
        if(primerToken == 0){
            token = lexico.yylex();
            if(token == null) {
                fintext = true;
                return;
            }
        }
        E();
        if(token == BnfsTokens.PUNTOYCOMA){
            out.add("Fin de cadena");
        }else{
            pilaError.add("Token esperado: ';'");
        }
    }
    public void E() throws IOException{
        out.add("E");
        T();
        if(token == BnfsTokens.OR)
            E();
        else
            return;
    }
    public void T() throws IOException{
        out.add("T");
        F();
        if(token == BnfsTokens.AND)
            T();
        else
            return;
    }
    public void F() throws IOException {
        out.add("F");
        if(primerToken == 0)
            primerToken = 1;
        else
            token = lexico.yylex();
        if (token == BnfsTokens.NOT) {
            F();
        } else if (token == BnfsTokens.FALSE || token == BnfsTokens.TRUE) {
            token = lexico.yylex();
            return;
        } else if (token == BnfsTokens.APARENTESIS) {
            E();
            if (token == BnfsTokens.CPARENTESIS)
                token = lexico.yylex();
            else
                pilaError.add("Falta token ')'");
        } else {
            pilaError.add("Caracter no esperado");
        }
    }
}
