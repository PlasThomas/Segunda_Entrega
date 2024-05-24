package Programas.ASAP;

import Programas.ASAP.LexicoASAP;
import Programas.ASAP.parser;

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