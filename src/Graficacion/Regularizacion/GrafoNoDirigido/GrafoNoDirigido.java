package Graficacion.Regularizacion.GrafoNoDirigido;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.*;
import java.util.ArrayList;

public class GrafoNoDirigido extends Application
{
    private Scene scene;
    private VBox vBox;
    private HBox hBox;
    private Button adyacencia;
    private TextField textNA,textNB;
    private Canvas lienzo;
    private GraphicsContext lapiz;
    private ArrayList<Nodo> nodos;
    private int[][] grafo;

    @Override
    public void start(Stage primaryStage) throws Exception {
        inicializarComponentes();
        primaryStage.setScene(scene);
        primaryStage.show();
        String temp;
        do {
            temp = JOptionPane.showInputDialog("Nodo");
            if (temp!=null)
                nodos.add(new Nodo(Integer.parseInt(temp)));
        }while(temp != null);
        grafo = new int[nodos.size()][nodos.size()];
        for (int i=0; i<nodos.size() ; i++) {
            for (int j=0; j<nodos.size() ; j++) {
                grafo[i][j] = 0;
            }
        }
        dibujarNodos();
    }
    private void inicializarComponentes(){
        nodos = new ArrayList<>();
        vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        adyacencia = new Button("Adyacencia");
        adyacencia.setOnAction(event -> adyacencia());
        textNA = new TextField();
        textNB = new TextField();
        lienzo = new Canvas();
        lienzo.setHeight(500);lienzo.setWidth(500);
        lapiz = lienzo.getGraphicsContext2D();
        hBox.getChildren().addAll(textNA,textNB);
        vBox.getChildren().addAll(new Label("GRAFO NO DIRIGIDO"),hBox,adyacencia,lienzo);
        scene = new Scene(vBox);
    }
    private void dibujarNodos(){
        double grado = 360/nodos.size();
        double contGrado = grado;
        double x,y;
        for (int i=0; i<nodos.size() ; i++) {
            x = (int) (250.0+(230.0*Math.cos(Math.toRadians(contGrado))));
            y = (int) (250.0+(230.0*Math.sin(Math.toRadians(contGrado))));
            contGrado = contGrado+grado;
            System.out.println(x+"x"+y);
            nodos.get(i).setX((int)x);
            nodos.get(i).setY((int)y);
            lapiz.clearRect(nodos.get(i).getX(),nodos.get(i).getY(),20,20);
            lapiz.setFill(Color.web("8cc573"));
            lapiz.fillOval(nodos.get(i).getX(),nodos.get(i).getY(),20,20);
            lapiz.setFill(Color.web("000000"));
            lapiz.fillText(String.valueOf(nodos.get(i).getValor()),nodos.get(i).getX(),nodos.get(i).getY()+15);
        }
    }
    private void adyacencia(){
        int nodoA = Integer.parseInt(textNA.getText());
        int nodoB = Integer.parseInt(textNB.getText());
        for (int i=0; i<nodos.size() ; i++) {
            for (int j=0; j<nodos.size() ; j++) {
                if (nodoA==nodos.get(i).getValor() && nodoB==nodos.get(j).getValor()){
                    grafo[i][j] = 1;
                    lapiz.setStroke(Color.web("8cc573"));
                    lapiz.strokeLine(nodos.get(i).getX(),nodos.get(i).getY(),nodos.get(j).getX(),nodos.get(j).getY());
                }
            }
        }
    }
}