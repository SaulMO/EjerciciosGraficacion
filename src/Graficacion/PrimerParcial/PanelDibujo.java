package Graficacion.PrimerParcial;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

public class PanelDibujo extends Stage
{
    private Scene scene;
    private AnchorPane anchorPane;
    private Canvas lienzo;
    private GraphicsContext graphicsContext;

    public PanelDibujo(Stage stage){
        this.crearPanel();
        this.initStyle(StageStyle.UNDECORATED);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(stage);
        this.setScene(scene);
        this.show();
    }
    private void crearPanel(){
        anchorPane = new AnchorPane();
        anchorPane.setMaxSize(1300,700); anchorPane.setPrefSize(1300,700); anchorPane.setMinSize(1300,700);
        anchorPane.styleProperty().set("-fx-background-color: #f4f2b8;");//new Color(0.0,0.0,0.0));
        Line x = new Line(0,350,1300,350),y = new Line(650,0,650,700);
        lienzo = new Canvas(1300,700);
        graphicsContext = lienzo.getGraphicsContext2D();
        anchorPane.getChildren().addAll(x,y,lienzo);

        dibujarElipse(-100,0,100,0,250);
        dibujarElipse(-200,50,100,50,270);
        scene = new Scene(anchorPane);
    }
    public void dibujarCirculo(int xp,int yp,int r) {
        graphicsContext.setFill(Color.web("#1a4939"));
        graphicsContext.fillOval(xp+650-2,350-yp-2,5,5);
        double y,y2;
        for (int x = (int)(xp-r) ; x<= (xp+r); x++){
            y = Math.sqrt((r*r) - ((x-xp)*(x-xp))) + yp;
            y2 = (yp - (y-yp));
            graphicsContext.fillOval(x+650,350-y,1,1);
            graphicsContext.fillOval(x+650,350-y2,1,1);
        }
    }
    /*Debido a que se dibujo una linea se pidio (x1,y1) y (x2,y2)*/
    public void dibujarLinea(double x1,double y1,double x2,double y2){
        graphicsContext.setFill(Color.web("582222"));
        graphicsContext.fillOval(x1+650-2,350-y1-2,5,5);
        graphicsContext.fillOval(x2+650-2,350-y2-2,5,5);
        double y,m,x;
        /*Este if es cuando x1 y x2 fueran iguales que solo dibujara una linea vertical
        * con un ciclo del menor valor en y ya sea y1 o y2 hasta el mayor valor en y
        * ya sea y1 o y2*/
        if (x1==x2){
            x=x1; y=y1;
            do {
                graphicsContext.fillOval(x+650,350-y,1,1);
                if (y1 < y2)
                    y++;
                else
                    y--;
            }while(y!=y2);
            /*En el else sacamos la pendiente guardandola en una variable llamada m
            * y poniendo a variable dependiente y, pudiendo asi usar la formula :
            * y = m(x-x1)+b donde el valor de x iba a ser asignado en un ciclo que va del
            * valor en x1 hasta el valor en x2 ya sea restando o sumando el xTemp*/
        }else{
            m=(y2-y1)/(x2-x1); x=x1;
            do {
                y=m*(x-x1)+y1;
                graphicsContext.fillOval(x+650,350-y,1,1);
                if (x1 < x2)
                    x++;
                else
                    x--;
            }while(x!=x2);
        }
    }
    /*Pide los valores a,b,c que son los coeficientes de ax^2+bx+c = 0*/
    public void dibujarFuncionCuadratica(double a,double b,double c){
        graphicsContext.setFill(Color.web("#045438"));
        double y;  double x = -650;
        /*En este ciclo sustituye los valores en la formula general y saca
        * el valor de la variable dependiente en y siempre y cuando no se pase de los limites del canvan*/
        do{
            y = ( (a*(x*x))+(b*(x))+ c);
            if (!(y>350||y<350||x>650||x<650))
                System.out.println("imprimi puntito");
                graphicsContext.fillOval(x+650-1,350-y-1,3,3);
            x++;
        }while(x < 1300);
    }
    /*El dibujo de la elpse se basa en el valor de los focos f1(x1,y1) y f2(x2,y2) y una
     * pita que va a ser el largo o distancia que es entre los focos */
    public void dibujarElipse(double fX1,double fY1,double fX2,double fY2,double pita){
        double disFocos = Math.sqrt(((fX2-fX1)*(fX2-fX1))+((fY2-fY1)*(fY2-fY1)));
        double a = ((pita-disFocos)/2) + (disFocos/2);
        double b = Math.sqrt(((pita/2)*(pita/2))-((disFocos/2)*(disFocos/2)));
        double y,y2,xt;
        if(fX1!=fX2){
            for (double x=(fX1-((pita-disFocos)/2)) ; x<=(fX2+((pita-disFocos)/2)) ; x++) {
                y = Math.sqrt((1 - ((x * x) / (a * a))) * (b * b));
                //y2 = (fY2 - (y - fY1));
                y2 = -Math.sqrt((1 - ((x * x) / (a * a))) * (b * b));
                graphicsContext.fillOval(x + 650, 350 - y, 1, 1);
                graphicsContext.fillOval(x + 650, 350 - y2, 1, 1);
            }
        }else if(fY1!=fY2){
            for (double yt=(fY1-((pita-disFocos)/2)) ; yt<=(fY2+((pita-disFocos)/2)) ; yt++) {
                xt = Math.sqrt((1 - ((yt * yt) / (a * a))) * (b * b));
                //y2 = (fY2 - (yT - fY1));
                graphicsContext.fillOval(xt + 650, 350 - yt, 1, 1);
               // graphicsContext.fillOval(x + 650, 350 - y2, 1, 1);
            }
        }
    }
}