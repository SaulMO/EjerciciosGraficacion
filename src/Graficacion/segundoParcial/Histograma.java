package Graficacion.segundoParcial;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Histograma extends Stage
{
    private int histR[];
    private int histG[];
    private int histB[];
    private int histGris[];
    private Scene scene;
    private AnchorPane anchorPane;
    private Canvas lienzo;
    private GraphicsContext graphicsContext;
    private int umbral,temp;

    public Histograma(Pixel[][] imagen){
        histR = new int[256];
        histG = new int[256];
        histB = new int[256];
        histGris = new int[256];
        for(int i=0 ; i<=255 ; i++){
            histR[i]=0;  histG[i]=0;  histB[i]=0;  histGris[i]=0;
        }
        for (int i=0 ; i<imagen.length ; i++){
            for (int j=0 ; j<imagen[0].length ; j++){
                histR[imagen[i][j].getR()] = histR[imagen[i][j].getR()] + 1;
                histG[imagen[i][j].getG()] = histG[imagen[i][j].getG()] + 1;
                histB[imagen[i][j].getB()] = histB[imagen[i][j].getB()] + 1;
                histGris[imagen[i][j].getGris()] = histGris[imagen[i][j].getGris()] + 1;
            }
        }

        //Crear Panel de Histograma
        anchorPane = new AnchorPane();
        anchorPane.setMaxSize(1200,550); anchorPane.setPrefSize(1200,550); anchorPane.setMinSize(1200,550);
        lienzo = new Canvas(1200,550);
        Line x=new Line(0,540,1200,540), y1=new Line(20,0,20,550), y2=new Line(320,0,320,550), y3=new Line(620,0,620,550), y4=new Line(920,0,920,550);
        graphicsContext = lienzo.getGraphicsContext2D();
        for (int i=0; i<=255 ; i++) {
            graphicsContext.setStroke(Color.web("#9c2d1c"));
            graphicsContext.strokeLine(32+i,540,32+i,540-(histR[i])/2);
            graphicsContext.setStroke(Color.web("#1c9c3b"));
            graphicsContext.strokeLine(332+i,540,332+i,540-(histG[i])/2);
            graphicsContext.setStroke(Color.web("#2183a0"));
            graphicsContext.strokeLine(632+i,540,632+i,540-(histB[i])/2);
            graphicsContext.setStroke(Color.web("#000000"));
            graphicsContext.strokeLine(932+i,540,932+i,540-(histGris[i])/2);
        }
        anchorPane.getChildren().addAll(lienzo,x,y1,y2,y3,y4);
        scene = new Scene(anchorPane);
        this.setScene(scene);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.initStyle(StageStyle.UNDECORATED);
        alerta.setContentText("UmbralRed = "+getUmbralR()+"\nUmbralGreen = "+getUmbralG()+"\nUmbralBlue = "+getUmbralB()+"\nUmbralBlancoNegro = "+getUmbralGris());
        alerta.showAndWait();
        this.show();
    }

    public int getUmbralR(){
        umbral=0;
        temp=histR[0];
        for (int i=1 ; i<=255 ; i++){
            if(histR[i]>temp){
                umbral=i;
                temp=histR[i];
            }
        }
        return umbral;
    }
    public int getUmbralG(){
        umbral=0;
        temp=histG[0];
        for (int i=1 ; i<=255 ; i++){
            if(histG[i]>temp){
                umbral=i;
                temp=histG[i];
            }
        }
        return umbral;
    }
    public int getUmbralB(){
        umbral=0;
        temp=histB[0];
        for (int i=1; i<=255 ; i++){
            if(histB[i]>temp)
                umbral=i;
                temp = histB[i];
        }
        return umbral;
    }
    public int getUmbralGris(){
        umbral=0;
        temp=histGris[0];
        for (int i=1; i<=255 ; i++){
            if(histGris[i]>temp)
                umbral=i;
                temp=histGris[i];
        }
        return umbral;
    }
}