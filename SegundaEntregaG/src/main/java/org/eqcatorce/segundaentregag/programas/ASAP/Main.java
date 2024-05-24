package org.eqcatorce.segundaentregag.programas.ASAP;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> out = null;
        ASAP asap = new ASAP();
        asap.setArchivo("src/main/java/org/eqcatorce/segundaentregag/programas/ASAP/fuente.txt");
        out = asap.task();
        for (String message : out) {
            System.out.println(message);
        }
    }
}