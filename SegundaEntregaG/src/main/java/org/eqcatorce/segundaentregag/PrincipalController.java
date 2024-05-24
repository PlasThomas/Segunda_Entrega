package org.eqcatorce.segundaentregag;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.eqcatorce.segundaentregag.programas.ASAP.ASAP;
import org.eqcatorce.segundaentregag.programas.ASDP;
import org.eqcatorce.segundaentregag.programas.BnfRec;
import org.eqcatorce.segundaentregag.programas.BnfSinRec;

import javax.swing.*;
import java.io.File;
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
        selectProgram.getItems().addAll("BNF Recursivo", "BNF No Recursivo", "Analizador Descendente", "Analizador Ascendente", "Creditos");
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
                    setTableView(bnfr.task(), "Bnf");
                } else if (selectedProgram.equals("BNF No Recursivo")) {
                    BnfSinRec bnfsr = new BnfSinRec();
                    bnfsr.setArchivo(path);
                    setTableView(bnfsr.task(), "Bnf");
                } else if (selectedProgram.equals("Analizador Descendente")){
                    ASDP asdp = new ASDP();
                    asdp.setArchivo(path);
                    setTableView(asdp.task(), "Asdp");
                } else if (selectedProgram.equals("Analizador Ascendente")) {
                    ASAP asap = new ASAP();
                    asap.setArchivo(path);
                    setTableView(asap.task(), "Ascendente");
                } else if (selectedProgram.equals("Creditos")){
                    ArrayList<String> creditos = new ArrayList<>();
                    creditos.add("De Ramón Pérez Isaac Abraham");
                    creditos.add("García Muñoz Jesús");
                    creditos.add("Plasencia Ramos José Manuel");
                    setTableView(creditos, "Ascendente");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Por favor selecciona una fuente y un programa", "Sope", JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void setTableView(ArrayList<String> piller, String type){
        tableView.getColumns().clear();

        if (type.equals("Bnf") || type.equals("Asdp")){
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

            for (String expr: piller){
                String estado = "";

                if (expr.equals("Cadena invalida") || expr.equals("Caracter no esperado") || expr.equals("Token esperado: ';'") || expr.equals("Caracter esperado ';'")
                || expr.equals("Fin de cadena") || expr.equals("Cadena valida") || expr.equals("Fin del Archivo")){
                    estado = expr;
                    expr = "" + (char) 903;
                }
                else{
                    estado = "" + (char) 903;
                }

                tableView.getItems().add(new Item("", expr, estado));
            }
        }
        else if (type.equals("Ascendente")) {
            TableColumn<Item, String> expresionColumn = new TableColumn<>("Expresión");
            expresionColumn.setCellValueFactory(cellData -> cellData.getValue().expresion);
            tableView.getColumns().clear();
            tableView.getColumns().add(expresionColumn);
            tableView.getItems().clear();

            for (String expr : piller){
                tableView.getItems().add(new Item("",expr,""));
            }
        }

    }
}