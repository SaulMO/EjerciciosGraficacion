package Graficacion.TercerParcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ColaAlumnosAplicacion extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vista/ColaServiciosEscolares.fxml"));
        primaryStage.setTitle("Aplicación Cola Servicios Escolares");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}