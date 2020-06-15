package Graficacion.TercerParcial.controlador;

import Graficacion.TercerParcial.modelo.Libro;
import Graficacion.TercerParcial.modelo.Pila;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPilaLibros implements Initializable
{
    @FXML private Button btnMeter,btnSacar;
    @FXML private Canvas lienzo;
    private GraphicsContext lapiz;
    private Pila pilaLibros;
    private int y;
    private Libro libro;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lapiz = lienzo.getGraphicsContext2D();
        btnMeter.setOnAction(event -> eventos(0));
        btnSacar.setOnAction(event -> eventos(1));
        pilaLibros = new Pila();
        y = 500;
    }

    private void eventos(int opcion){
        if (opcion==0) //Evento Boton Meter Libro
        {
            pilaLibros.meterObject(new Libro(JOptionPane.showInputDialog("cveLibro"),
                                            JOptionPane.showInputDialog("Nombre"),
                                            JOptionPane.showInputDialog("Autor"),
                                            Integer.parseInt(JOptionPane.showInputDialog("Año Publicación")),
                                            Double.parseDouble(JOptionPane.showInputDialog("Peso del Libro"))));

            agregarLibro();
            y = y-20;
        }
        else if(opcion==1) //Eventos Boton Sacar Libro
        {
            libro = (Libro) pilaLibros.sacarObject();
            if (libro!=null){
                y = y + 20;
                quitarLibro();
                JOptionPane.showMessageDialog(null,"Se saca el libro cveLibro = "+libro.getCveLibro()+
                        "\nNombre = "+libro.getNombre()+
                        "\nAutor = "+libro.getAutor()+
                        "\nAño = "+libro.getYear()+
                        "\nPeso = "+libro.getPeso());
            }else{
                JOptionPane.showMessageDialog(null,"No hay mas libros por sacar");
            }
        }
    }
    private void quitarLibro(){
        for (int i=150 ; i<=350 ; i++){
            for (int j=y ; j>y-20 ; j--){
                lapiz.clearRect(i,j,1,1);
            }
        }
    }

    private void agregarLibro(){
        lapiz.setFill(Color.web("582222"));
        for (int i=150 ; i<=350 ; i++){
            for (int j=y ; j>y-20 ; j--){
                lapiz.fillOval(i,j,1,1);
            }
        }
    }
}