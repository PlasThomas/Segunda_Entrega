package Programas;

import java.io.*;
import java.util.ArrayList;

public class BnfRec {
    private ArrayList<String> pilaError = new ArrayList<String>();
    private Lexico lexico;
    private BnfsTokens token;
    public static void main(String[] args) throws IOException {
        Main app = new Main();
        Reader rd = new BufferedReader(new FileReader("fuente.txt"));
        app.lexico = new Lexico(rd);
        do {
            app.S();
            if(app.pilaError.isEmpty())
                System.out.println("Cadena valida");
            else{
                System.out.println("Cadena invalida");
                for(int i = 0; i < app.pilaError.size();i++)
                    System.out.println(app.pilaError.get(i));
                System.out.println("\n\n");
            }
            app.pilaError.clear();
        }while(app.token != null);
/*
 E-> T or E | T
 T-> F and T | F
 F-> not F | true | false | ( E )

 */
    }
    public void S() throws IOException {
        System.out.println("S");
        E();
        if(token == BnfsTokens.PUNTOYCOMA){
            System.out.println("Fin de cadena");
        }else{
            pilaError.add("Token esperado: ';'");
        }
    }
    public void E() throws IOException{
        System.out.println("E");
        T();
        if(token == BnfsTokens.OR)
            E();
        else
            return;
    }
    public void T() throws IOException{
        System.out.println("T");
        F();
        if(token == BnfsTokens.AND)
            T();
        else
            return;
    }
    public void F() throws IOException {
        System.out.println("F");
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
