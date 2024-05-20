package Interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaz/fxml/VistaPrincipal.fxml"));
        Parent root = loader.load();

        // Configurar la escena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Configurar el título de la ventana
        primaryStage.setTitle("Vista Principal");

        // Mostrar la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
