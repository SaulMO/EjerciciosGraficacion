package Graficacion.TercerParcial.controlador;

import Graficacion.TercerParcial.modelo.Lista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerListadoMaterias implements Initializable
{
    @FXML private Canvas lienzo;
    @FXML private Button btnMeter,btnSacar,btnMostrar;
    private Lista lista;
    private int materia,materiaTemp;
    private GraphicsContext lapiz;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lapiz = lienzo.getGraphicsContext2D();
        btnMeter.setOnAction(event -> eventos(1));
        btnSacar.setOnAction(event -> eventos(0));
        btnMostrar.setOnAction(event -> eventos(2));
        lista = new Lista();
        materia = 0;
    }

    public void eventos(int opcion){
        if (opcion == 1){//btnMeter
            lista.insertarLSD(materia);
            materiaTemp = materia;
            meterMateria();
            JOptionPane.showMessageDialog(null,"Se metio la materia "+materia);
            materia = materia+1;
        }
        if (opcion == 0){//btnSacar
            materiaTemp = Integer.parseInt(JOptionPane.showInputDialog("Materia a sacar"));
            lista.eliminarLSD(materiaTemp);
            sacarMateria();
        }
        if (opcion == 2){//btnMostrarMaterias
            lista.mostrarLSD();
        }
    }

    public void meterMateria(){
        lapiz.setFill(Color.web(decHex((int)(Math.random()*255))+decHex((int)(Math.random()*255))+decHex((int)(Math.random()*255))));
        int y = 500 - (materiaTemp * 20);
        for (int i=150 ; i<=350 ; i++){
            for (int j=y ; j>y-20 ; j--){
                lapiz.fillOval(i,j,1,1);
            }
        }
    }

    public void sacarMateria(){
        int y = 500 - (materiaTemp * 20);
        for (int i=150 ; i<=350 ; i++){
            for (int j=y ; j>y-20 ; j--){
                lapiz.clearRect(i,j,1,1);
            }
        }
    }

    private String decHex(int n){
        if (n<=15)
            return "0"+Integer.toHexString(n);
        else
            return Integer.toHexString(n);
    }
}