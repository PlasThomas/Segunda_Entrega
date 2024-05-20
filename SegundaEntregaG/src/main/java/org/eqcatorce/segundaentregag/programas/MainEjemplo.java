package org.eqcatorce.segundaentregag.programas;

import java.io.IOException;
import java.util.ArrayList;

public class MainEjemplo {
    public static void main(String[] args) throws IOException {
        BnfRec bnfr = new BnfRec();
        bnfr.setArchivo("src/main/java/Programas/fuente.txt");
        ArrayList<String> out = bnfr.task();
        for (String s : out) System.out.println(s);
    }
}
