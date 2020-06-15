package Graficacion.TercerParcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ListadoMateriasAplicacion extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vista/ListadoMaterias.fxml"));
        primaryStage.setTitle("Aplicación Listas Enlazadas");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
