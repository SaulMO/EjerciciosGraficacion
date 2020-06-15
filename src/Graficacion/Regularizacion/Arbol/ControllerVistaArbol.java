package Graficacion.Regularizacion.Arbol;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;

public class ControllerVistaArbol implements Initializable
{
    @FXML private Canvas lienzo;
    @FXML private TextField textDato,textBuscar;
    private GraphicsContext lapiz;
    private Arbol arbol;
    private NodoArbol nodoArbol;
    private Queue<NodoArbol> camino;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nodoArbol = null;
        lapiz = lienzo.getGraphicsContext2D();
        arbol = new Arbol();
    }

    public void meterDato(ActionEvent actionEvent) {
        nodoArbol = arbol.insertarDato(Integer.parseInt(textDato.getText()));
        if (nodoArbol!=null){
            dibujarNodo("e9ba8e");
        }
    }
    public void buscarNodo(ActionEvent actionEvent) {
        camino = arbol.getCamino(Integer.parseInt(textBuscar.getText()));
        nodoArbol = camino.poll();
        do{
            nodoArbol = camino.poll();
            if (nodoArbol!=null)
                dibujarNodo("8cc573");
        }while(nodoArbol!=null);
    }
    private void dibujarNodo(String color){
        lapiz.clearRect(nodoArbol.getCoordenadaX(),nodoArbol.getCoordenadaY(),20,20);
        lapiz.setFill(Color.web(color));
        lapiz.fillOval(nodoArbol.getCoordenadaX(),nodoArbol.getCoordenadaY(),20,20);
        lapiz.setFill(Color.web("000000"));
        lapiz.fillText(String.valueOf(nodoArbol.getInfo()),nodoArbol.getCoordenadaX(),nodoArbol.getCoordenadaY()+15);
    }
}