package Graficacion.CuartoParcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AplicacionGrafica3D extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Grafica3D/vistaGrafica3D.fxml"));
        primaryStage.setTitle("Aplicación Listas Enlazadas");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    //juana.flores@itcelaya.edu.mx
}