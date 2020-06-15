package Graficacion.Regularizacion.Arbol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vistaArbol.fxml"));
        primaryStage.setTitle("Arbol binario");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}