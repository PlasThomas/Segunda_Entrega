package org.eqcatorce.segundaentregag;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.eqcatorce.segundaentregag.programas.BnfRec;
import org.eqcatorce.segundaentregag.programas.BnfSinRec;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrincipalController {

    public static class Item {
        private final SimpleStringProperty token;
        private final SimpleStringProperty expresion;
        private final SimpleStringProperty estado;

        public Item(String token, String expresion, String estado) {
            this.token = new SimpleStringProperty(token);
            this.expresion = new SimpleStringProperty(expresion);
            this.estado = new SimpleStringProperty(estado);
        }

        public String getToken() {
            return token.get();
        }

        public String getExpresion() {
            return expresion.get();
        }

        public String getEstado() {
            return estado.get();
        }
    }
    @FXML
    private Label titleText;
    @FXML
    private ComboBox<String> selectProgram;
    @FXML
    private Button selectFont;
    @FXML
    private TableView<Item> tableView;
    @FXML
    private Label selectedPath;
    @FXML
    private Button letsGo;

    private String path;


    @FXML
    public void initialize() {
        // Inicializar ComboBox con cuatro elementos
        selectProgram.setPromptText("Programa ...");
        selectProgram.getItems().addAll("BNF Recursivo", "BNF No Recursivo", "Analizador Descendente", "Analizador Ascendente");
    }

    @FXML
    private void setFontPath() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Archivo de Fuente");

        // Filtrar solo archivos de texto
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));
        Stage stage = (Stage) selectFont.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);


        if (selectedFile != null) {
            path = selectedFile.getAbsolutePath();
            selectedPath.setText("Seleccionado: " + path);
        } else {
            JOptionPane.showMessageDialog(null, "Selección de archivo cancelada.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    private  void setTitleText() {
        titleText.setText("Segunda entrega: [" + selectProgram.getSelectionModel().getSelectedItem() + "]");
    }

    @FXML
    private void startPrograms(){
        String selectedProgram = selectProgram.getSelectionModel().getSelectedItem();
        try{
            if(path != null && selectedProgram != null) {
                if (selectedProgram.equals("BNF Recursivo")) {
                    BnfRec bnfr = new BnfRec();
                    bnfr.setArchivo(path);
                    setTableView(bnfr.task());
                } else if (selectedProgram.equals("BNF No Recursivo")) {
                    BnfSinRec bnfsr = new BnfSinRec();
                    bnfsr.setArchivo(path);
                    setTableView(bnfsr.task());
                    System.out.println("BNF No Recursivo");
                } else if (selectedProgram.equals("Analizador Descendente")) {
                    System.out.println("Analizador Descendente");
                } else if (selectedProgram.equals("Analizador Ascendente")) {
                    System.out.println("Analizador Ascendente");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor selecciona una fuente y un programa", "Sope", JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void setTableView(ArrayList<String> piller){

        // Crear la columna "Expresión"
        TableColumn<Item, String> expresionColumn = new TableColumn<>("Expresión");
        expresionColumn.setCellValueFactory(cellData -> cellData.getValue().expresion);

        // Crear la columna "Estado"
        TableColumn<Item, String> estadoColumn = new TableColumn<>("Estado");
        estadoColumn.setCellValueFactory(cellData -> cellData.getValue().estado);

        // Añadir las columnas a la tabla
        tableView.getColumns().clear();
        tableView.getColumns().add(expresionColumn);
        tableView.getColumns().add(estadoColumn);

        tableView.getItems().clear();
        for (String expresion : piller) {
            String estado = "";
            if (expresion.equals("Cadena invalida") || expresion.equals("Caracter no esperado") || expresion.equals("Token esperado: ';'")){
                estado = expresion;
                expresion = "-";
            }
            else estado = "aceptado";

            tableView.getItems().add(new Item("", expresion, estado));
        }
    }
}