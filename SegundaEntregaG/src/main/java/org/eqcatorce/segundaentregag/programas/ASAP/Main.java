package org.eqcatorce.segundaentregag.programas.ASAP;

import org.eqcatorce.segundaentregag.programas.ASAP.LexicoASAP;
import org.eqcatorce.segundaentregag.programas.ASAP.parser;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> out = null;
        ASAP asap = new ASAP();
        asap.setArchivo("src/main/java/Programas/ASAP/fuente.txt");
        out = asap.task();
        for (String message : out) {
            System.out.println(message);
        }
    }
}