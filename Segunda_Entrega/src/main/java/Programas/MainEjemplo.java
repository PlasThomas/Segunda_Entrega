package Programas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainEjemplo {
    public static void main(String[] args) throws IOException {
        ArrayList<String> out = new ArrayList<String>();
        /*
        BnfRec bnfr = new BnfRec();
        bnfr.setArchivo("src/main/java/Programas/fuente.txt");
        ArrayList<String> out = bnfr.task():
        */
        ASDP asdp = new ASDP();
        asdp.setArchivo("src/main/java/Programas/fuente.txt");
        out = asdp.task();

        for (String s : out) System.out.println(s);
    }
}
