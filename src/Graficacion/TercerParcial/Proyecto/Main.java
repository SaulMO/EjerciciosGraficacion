package Graficacion.TercerParcial.Proyecto;

import Graficacion.TercerParcial.Proyecto.Modelo.ColaProcesos;
import Graficacion.TercerParcial.Proyecto.Modelo.ListaOrdenadaProcesos;
import Graficacion.TercerParcial.Proyecto.Modelo.Proceso;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.util.Calendar;

public class Main extends Application
{
    /*
    Scene scene;
    VBox vBox;
    Button meter,sacar,mostrar;
    ListaOrdenadaProcesos listaOrdenada;
    int contPro;
    Proceso proceso;*/
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Vista/vista.fxml"));
        primaryStage.setTitle("Scheduler");
        //iniciar();
        primaryStage.setScene(new Scene(root));
        //primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*
    public void iniciar(){
        listaOrdenada = new ListaOrdenadaProcesos();
        contPro = 0;
        vBox = new VBox(10);
        meter = new Button("meter");
        sacar = new Button("sacar");
        mostrar = new Button("mostrar");
        vBox.getChildren().addAll(meter,sacar,mostrar);
        meter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listaOrdenada.insertarLSO(new Proceso(contPro));
                contPro++;
            }
        });
        sacar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                proceso = listaOrdenada.eliminarProcesoLSO();
                System.out.println("P"+proceso.getIdProceso()+"hora "+proceso.getHoraLlegada().get(Calendar.HOUR_OF_DAY)+":"+proceso.getHoraLlegada().get(Calendar.MINUTE)+":"+proceso.getHoraLlegada().get(Calendar.SECOND)+" Tiempo = "+proceso.getTiempo());

            }
        });
        mostrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listaOrdenada.mostrarLSO();
            }
        });
        scene = new Scene(vBox);
    }*/
}