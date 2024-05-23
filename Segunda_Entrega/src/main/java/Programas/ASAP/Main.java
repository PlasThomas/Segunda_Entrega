package Programas.ASAP;

import ASAP.LexicoASAP;
import ASAP.parser;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> out = null;
        /*
        BnfRec bnfr = new BnfRec();
        bnfr.setArchivo("fuente.txt");
        out = bnfr.task();

        ASDP asdp = new ASDP();
        asdp.setArchivo("fuente.txt");
        out = asdp.task();

        ASAP asap = new ASAP();
        asap.setArchivo("fuente.txt");
        out = asap.task();
*/
        String renglon;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fuente.txt"));
            while((renglon = reader.readLine())!= null){
                Reader buffer = new StringReader(renglon);
                LexicoASAP lexer = new LexicoASAP(buffer);
                parser par = new parser(lexer);
                par.parse();
                ArrayList<String> messages = par.getMessages();
                for (String message : messages) {
                    System.out.println(message);
                }
                par = null;
                lexer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}