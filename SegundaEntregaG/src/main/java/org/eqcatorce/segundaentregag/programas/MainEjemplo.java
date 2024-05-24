package org.eqcatorce.segundaentregag.programas;

import java.io.IOException;
import java.util.ArrayList;

public class MainEjemplo {
    public static void main(String[] args) throws IOException {
        BnfRec bnfr = new BnfRec();
        bnfr.setArchivo("src/main/java/org/eqcatorce/segundaentregag/programas/fuente.txt");
        ArrayList<String> out = bnfr.task();
        for (String s : out) System.out.println(s);

        for (int i = 0; i < 1024; i++){
            System.out.println(i + " = " + (char) i);
        }
    }
}
