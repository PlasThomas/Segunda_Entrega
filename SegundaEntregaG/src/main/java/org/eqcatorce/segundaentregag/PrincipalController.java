package org.eqcatorce.segundaentregag;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class PrincipalController {
    @FXML
    private Label titleText;
    @FXML
    private ComboBox<String> selectProgram;
    @FXML
    private Button selectFont;
    @FXML
    private TableView<String> tableView;
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
    private void startPrograms(){
        String selectedProgram = selectProgram.getSelectionModel().getSelectedItem();

        if(path != null && selectedProgram != null) {
            if (selectedProgram.equals("BNF Recursivo")) {
                System.out.println("BNF Recursivo");
            } else if (selectedProgram.equals("BNF No Recursivo")) {
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
    }

    private void setTableView(){

    }
}