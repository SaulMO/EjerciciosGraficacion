package Graficacion.CuartoParcial.Grafica3D;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorGrafica3D implements Initializable
{
    @FXML private TextField txtCx,txtPx,txtCy,txtPy,txtCz,txtPz,txtCte;
    @FXML private Button btnEmpezar;
    @FXML private Canvas lienzo;
    private GraphicsContext lapiz;
    private double x,y,z,xTemp,yTemp,temp2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnEmpezar.setOnAction(event -> hacerGrafica());
        lapiz = lienzo.getGraphicsContext2D();
        int xTemp = 250;
        int yTemp = 250;
        lapiz.setFill(Color.web("d59050"));
        lapiz.fillOval(xTemp,yTemp,4,4);
        lapiz.setFill(Color.web("000000"));
    }

    private void hacerGrafica(){
        for (int i=-20 ; i<=20 ; i++) {
            y = i;
            z = i;
            System.out.println("AAx="+x+" y="+y+" z="+z);
            funcion();
            System.out.println("x="+x+" y="+y+" z="+z);
            xTemp = 250;
            yTemp = 250;
            pintarPunto();
        }
    }
    private void funcion(){
        int cx = Integer.parseInt(txtCx.getText());
        int px = Integer.parseInt(txtPx.getText());
        int cy = Integer.parseInt(txtCy.getText());
        int py = Integer.parseInt(txtPy.getText());
        int cz = Integer.parseInt(txtCz.getText());
        int pz = Integer.parseInt(txtPz.getText());
        int cte = Integer.parseInt(txtCte.getText());
        if (cx!=0 && px!=0){
            System.out.println();
            temp2 = -(cy*Math.pow(y,py));
            System.out.println("Temp "+temp2);
            //x = Math.pow(((cte-(cy*Math.pow(y,py))-(cz*Math.pow(z,pz)))/cx),(1.0/(double)px));
        }
        /*if (cy!=0 && py!=0){
            y = Math.pow(((cte-(cx*Math.pow(x,px))-(cz*Math.pow(z,pz)))/cy),(1.0/(double)px));
        }
        if (cz!=0 && pz!=0){
            z = Math.pow(((cte-(cy*Math.pow(y,py))-(cx*Math.pow(x,px)))/cz),(1.0/(double)px));
        }*/
    }
    private void pintarPunto(){
        //mover en x;
        xTemp = xTemp - x*10;
        yTemp = yTemp + x*10;
        //mover en y
        xTemp = xTemp + y*10;
        yTemp = yTemp + y*10;
        //mover en z
        yTemp = yTemp - z*10;
        lapiz.fillRect(xTemp,yTemp,2,2);
    }
}