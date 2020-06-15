package Graficacion.TercerParcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PilaLibrosAplicacion extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vista/PilaLibros.fxml"));
        primaryStage.setTitle("Aplicación Pila Libros");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}