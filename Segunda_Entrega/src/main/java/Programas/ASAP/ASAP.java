package Programas.ASAP;
import java.io.*;
import java.util.ArrayList;

public class ASAP {
    String archivo;
    private ArrayList<String> salida = new ArrayList<String>();

    /*public ArrayList<String> task() throws Exception {
        try {
            Reader reader = new FileReader(archivo);
            LexicoASAP lexer = new LexicoASAP(reader);
            parser parser = new parser(lexer);

            parser.parse();

            ArrayList<String> messages = parser.getMessages();
            for (String message : messages) {
                salida.add(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salida;
    }*/
    public void setArchivo(String path){
        this.archivo = path;
    }
}
