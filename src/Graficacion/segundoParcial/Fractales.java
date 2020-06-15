package Graficacion.segundoParcial;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Fractales extends Stage
{
    private Scene scene;
    private AnchorPane anchorPane;
    private Canvas lienzo;
    private GraphicsContext graphicsContext;
    private int figura[][];
    private int nvaFigura[][];
    private TextArea txtArea;

    public Fractales(){
        anchorPane=new AnchorPane();
        anchorPane.setMaxSize(500,500); anchorPane.setPrefSize(500,500); anchorPane.setMinSize(500,500);
        anchorPane.styleProperty().set("-fx-background-color: #ffffff;");//new Color(0.0,0.0,0.0));
        lienzo=new Canvas(500,500);
        graphicsContext=lienzo.getGraphicsContext2D();
        anchorPane.getChildren().add(lienzo);
        scene=new Scene(anchorPane);
        txtArea = new TextArea();
        figura = new int[500][500];
        nvaFigura = new int[500][500];
        graphicsContext.setFill(Color.web("#ffffff"));
        for (int y=0 ; y<500 ; y++){
            for (int x=0 ; x<500 ; x++){
                figura[y][x] = 0;
                graphicsContext.fillOval(x,y,1,1);
            }
        }

        this.initModality(Modality.APPLICATION_MODAL);
        this.setScene(scene);
        this.show();

        int tempValor = 1;
        int iteracion = 0;
        fractalCuadro(Integer.parseInt(JOptionPane.showInputDialog("Teclea una iteración del fractal")));
        /*do{
            tempValor = JOptionPane.showConfirmDialog(null,"MasFractal?");
            if (tempValor==0){
                fractalCuadro(iteracion);
            }
            iteracion++;
        }while(tempValor==0);*/
    }
    //int i,double iteracion
    public void fractalCuadro(int iteracion){
        int cuadros=0,pixeles=500;
        int contNegro=0;
        boolean negro = true;
        for (int i=0 ; i<=iteracion ; i++){
            if (i==0){
                System.out.println("EstoyAqui");
                cuadros = 4;
                pixeles = pixeles / 2;
            }else{
                cuadros = cuadros * 4;
                pixeles = pixeles / 2;
            }
        }
        System.out.println("Pixeles="+pixeles +"\tCuadros="+cuadros);
        for (int i=0; i<Math.sqrt(cuadros) ; i++) {
            contNegro++;
            negro = true;
            for (int j=0; j<Math.sqrt(cuadros) ; j++) {
                if (j<contNegro){
                    if (i%2==0){
                        if (negro){
                            graphicsContext.setFill(Color.web("#000000"));
                            negro = false;
                        }else{
                            graphicsContext.setFill(Color.web("#FFFFFF"));
                            negro = true;
                        }
                    }else
                        graphicsContext.setFill(Color.web("#000000"));
                }
                else
                    graphicsContext.setFill(Color.web("#ffffff"));
                System.out.println((i*pixeles)+"x"+((i+1)*pixeles)+"\t"+(j*pixeles)+"x"+((j+1)*pixeles));
                for (int k=(i*pixeles) ; k<((i+1)*pixeles) ; k++) {
                    for (int l=(j*pixeles) ; l<((j+1)*pixeles) ; l++) {
                        graphicsContext.fillOval(l,k,1,1);
                    }
                }
            }
        }
    }
}