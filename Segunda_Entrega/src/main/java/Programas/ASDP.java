package Programas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.*;

public class ASDP {
    private boolean fincadena = false;
    private FileReader archivo;
    private Stack<Character> simbolos = new Stack<Character>();
    private Stack<String> errores = new Stack<String>();
    private Queue<Character> entrada = new LinkedList<Character>();
    private ArrayList<String> salida = new ArrayList<String>();
    public ArrayList<String> task(){
        lectArr(archivo, entrada);
        do{
            simbolos.push(';');
            simbolos.push('S');
            S();
            if(errores.empty())
                salida.add("Cadena valida \n");
            else{
                salida.add("Cadena invalida");
                salida.addAll(errores);
                simbolos.clear();
                while(entrada.peek() != ';')
                    entrada.poll();
                entrada.poll();
                errores.clear();

            }
        } while(!entrada.isEmpty());
        return salida;
    }
    private void S() {
        salida.add("S");
        if (entrada.peek() == 'a' || entrada.peek() == 'b'){
            reducir('S');
            A();
        }else{
            errores.push("caracter invalido");
        }
        if(simbolos.peek() == ';' && entrada.peek() == ';' ) {
            System.out.println("fin de cadena");
            entrada.poll();
            simbolos.pop();
        }
    }
    private void A(){
        salida.add("A");
        if (entrada.peek() == 'a' || entrada.peek() == 'b'){
            reducir('A');
            B();
        }else{
            errores.push("caracter invalido");
        }
    }
    private void B(){
        salida.add("B");
        if (entrada.peek() == 'b'){
            reducir('B');
        }else{
            errores.push("caracter invalido");
        }
    }
    private void C(){
        salida.add("C");
        if (entrada.peek() == 'c' || entrada.peek() == 'd'){
            reducir('C');
        }else{
            errores.push("caracter invalido");
        }
    }
    private void consumir(){
        simbolos.pop();
        entrada.poll();
    }
    private void reducir(char regla){
        switch (regla){
            case 'S':
                simbolos.pop();
                simbolos.push('B');
                simbolos.push('A');
                break;
            case 'A':
                if (entrada.peek() == 'a'){
                    simbolos.pop();
                    simbolos.push('a');
                    consumir();
                }else if(entrada.peek() == 'b'){
                    simbolos.pop();
                }
                break;
            case 'B':
                simbolos.pop();
                simbolos.push('d');
                simbolos.push('C');
                simbolos.push('b');
                if(entrada.peek() == 'b'){
                    consumir();
                    C();
                    if(entrada.peek() == 'd')
                        consumir();
                    else
                        errores.push("caracter invalido");
                }else
                    errores.push("caracter invalido");
                break;
            case 'C':
                if (entrada.peek() == 'c'){
                    simbolos.pop();
                    simbolos.push('c');
                    consumir();
                }else if(entrada.peek() == 'd'){
                    simbolos.pop();
                }
                break;
        }
    }
    private void lectArr(FileReader archivo, Queue<Character> contenido){
        BufferedReader lect;
        String [] cad;
        String renglon;
        try{
            if(archivo.ready()){
                lect = new BufferedReader(archivo);
                while((renglon = lect.readLine()) != null) {
                    cad = renglon.split("\\s");
                    for (int i = 0; i < cad.length; i++) {
                        for (int j = 0; j < cad[i].length(); j++) {
                            contenido.add(cad[i].charAt(j));
                        }
                    }
                }
            }else{
                System.out.println("El archivo no está listo");
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void setArchivo(String path) throws FileNotFoundException {
        this.archivo = new FileReader(path);
    }
}