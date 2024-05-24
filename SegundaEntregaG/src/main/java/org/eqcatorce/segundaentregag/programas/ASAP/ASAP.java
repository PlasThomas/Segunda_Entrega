package org.eqcatorce.segundaentregag.programas.ASAP;
import java.io.*;
import java.util.ArrayList;

public class ASAP {
    private FileReader archivo;
    private ArrayList<String> salida = new ArrayList<>();

    public void setArchivo(String path) throws FileNotFoundException {
        this.archivo = new FileReader(path);
    }
    public ArrayList<String> task(){
        String renglon;
        try {
            BufferedReader reader = new BufferedReader(archivo);
            while((renglon = reader.readLine())!= null){
                Reader buffer = new StringReader(renglon);
                LexicoASAP scanner = new LexicoASAP(buffer);
                parser par = new parser(scanner);
                par.parse();
                salida.addAll(par.getMessages());
                par.clearMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salida;
    }
}