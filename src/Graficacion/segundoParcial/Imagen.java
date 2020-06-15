package Graficacion.segundoParcial;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Imagen extends Stage
{
    private Pixel[][] imagen;
    private Pixel[][] imagenBackup;
    private Color color;
    private Scene scene;
    private AnchorPane anchorPane;
    private Canvas lienzo;
    private GraphicsContext graphicsContext;
    private Histograma histograma;
    private int ancho,alto;

    public Imagen(File file){
        try {
            //CrearVentana
            String colorAux;
            BufferedImage image = ImageIO.read(file);
            ancho = image.getWidth();
            alto = image.getHeight();
            imagen = new Pixel[alto][ancho];
            imagenBackup = new Pixel[alto][ancho];
            anchorPane = new AnchorPane();
            anchorPane.setMaxSize(ancho,alto); anchorPane.setPrefSize(ancho,alto); anchorPane.setMinSize(ancho,alto);
            lienzo = new Canvas(ancho,alto);
            graphicsContext = lienzo.getGraphicsContext2D();
            anchorPane.getChildren().addAll(lienzo);
            scene = new Scene(anchorPane);
            this.setScene(scene);
            this.show();
            for (int i=0 ; i<alto ; i++){
                for (int j=0 ; j<ancho ; j++){
                    color = new Color(image.getRGB(j,i));
                    imagen[i][j] = new Pixel(color.getRed(),color.getGreen(),color.getBlue(),
                            (color.getRed()+color.getGreen()+color.getBlue())/3);
                    imagenBackup[i][j] = new Pixel(color.getRed(),color.getGreen(),color.getBlue(),
                            (color.getRed()+color.getGreen()+color.getBlue())/3);
                    graphicsContext.setFill(javafx.scene.paint.Color.web("#"+imagen[i][j].getRHex()+imagen[i][j].getGHex()+imagen[i][j].getBHex()));
                    graphicsContext.fillOval(j,i,1,1);
                }
            }
            histograma = new Histograma(imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*El filtro pasa baja consiste en cambiar el color de Pixel a 255 tanto en red como en green y blue
    * en los lugares donde el numero de pixel sea mayor el umbral del histograma, donde el umbral se obtiene
    * mediante la mediana de todo el histograma*/
    public void filtroPasaBaja(){
        for (int i=0 ; i<alto ; i++){
            for (int j=0 ; j<ancho ; j++){
                if (imagen[i][j].getR()>histograma.getUmbralR())
                    imagen[i][j].setR(255);
                if (imagen[i][j].getG()>histograma.getUmbralG())
                    imagen[i][j].setG(255);
                if (imagen[i][j].getB()>histograma.getUmbralB())
                    imagen[i][j].setB(255);
                graphicsContext.setFill(javafx.scene.paint.Color.web("#"+imagen[i][j].getRHex()+
                        imagen[i][j].getGHex()+imagen[i][j].getBHex()));
                graphicsContext.fillOval(j,i,1,1);
            }
        }
        reestablecerImagen();
    }

    /*El filtro pasa baja consiste en cambiar el color de Pixel a 0 tanto en red como en green y blue
     * en los lugares donde el numero de pixel sea menor el umbral del histograma, donde el umbral se obtiene
     * mediante la mediana de todo el histograma*/
    public void filtroPasaAlta(){
        for (int i=0 ; i<alto ; i++){
            for (int j=0 ; j<ancho ; j++){
                if (imagen[i][j].getR()<histograma.getUmbralR())
                    imagen[i][j].setR(0);
                if (imagen[i][j].getG()<histograma.getUmbralG())
                    imagen[i][j].setG(0);
                if (imagen[i][j].getB()<histograma.getUmbralB())
                    imagen[i][j].setB(0);
                graphicsContext.setFill(javafx.scene.paint.Color.web("#"+imagen[i][j].getRHex()+
                        imagen[i][j].getGHex()+imagen[i][j].getBHex()));
                graphicsContext.fillOval(j,i,1,1);
            }
        }
        reestablecerImagen();
    }
    /*Metodo pasa banda donde das los intervalos a y b del color red green y blue*/
    public void filtroBanda(int umbralRedA,int umbralGreenA,int umbralBlueA,int umbralRedB,int umbralGreenB,int umbralBlueB){
        if(umbralRedA>=umbralRedB ||umbralGreenA>=umbralGreenB || umbralBlueA>=umbralBlueB){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Hey");
            alert.setContentText("Recuerda un elemento umbral A tiene que ser menor a valor umbral B correspondiente a su color");
            alert.showAndWait();
        }else{
            /*Los valores fuera de los rangos se cambian a 0*/
            for (int i=0 ; i<alto ; i++){
                for (int j=0 ; j<ancho ; j++){
                    if (imagen[i][j].getR()<umbralRedA||imagen[i][j].getR()>umbralRedB)
                        imagen[i][j].setR(0);
                    if (imagen[i][j].getG()<umbralGreenA||imagen[i][j].getG()>umbralGreenB)
                        imagen[i][j].setG(0);
                    if (imagen[i][j].getB()<umbralBlueA||imagen[i][j].getB()>umbralBlueB)
                        imagen[i][j].setB(0);
                    /*Al final la matriz que se cambio se pinta en el canva*/
                    graphicsContext.setFill(javafx.scene.paint.Color.web("#"+imagen[i][j].getRHex()
                            +imagen[i][j].getGHex()+imagen[i][j].getBHex()));
                    graphicsContext.fillOval(j,i,1,1);
                }
            }
        }
        reestablecerImagen();
    }
    /*El método negativo de la imagen se encarga de pasar el contrario del valor de pixel, tanto en
    * rojo como verde y azul*/
    public void negativoImagen(){
        for (int i=0 ; i<alto ; i++){
            for (int j=0 ; j<ancho ; j++){
                imagen[i][j].setR(255 - imagen[i][j].getR());
                imagen[i][j].setG(255 - imagen[i][j].getG());
                imagen[i][j].setB(255 - imagen[i][j].getB());
                graphicsContext.setFill(javafx.scene.paint.Color.web("#"+imagen[i][j].getRHex()+
                        imagen[i][j].getGHex()+imagen[i][j].getBHex()));
                graphicsContext.fillOval(j,i,1,1);
            }
        }
        reestablecerImagen();
    }
    /*La media consiste en que en 9 pixeles de 3x3 sacar
    * una mediana de un pixel logrando con esto dar mas definicion a la imagen
    * esto se realiza en los colores rojo, verde y azul*/
    public void media(){
        int sumR=0,mediaR;
        int sumG=0,mediaG;
        int sumB=0,mediaB;
        for (int i=1 ; i<alto-1 ; i++){
            for (int j=1 ; j<ancho-1 ; j++) {
                sumR = sumR + imagen[i-1][j-1].getR();sumR = sumR + imagen[i-1][j].getR();
                sumR = sumR + imagen[i-1][j+1].getR();sumR = sumR + imagen[i][j-1].getR();
                sumR = sumR + imagen[i][j].getR();sumR = sumR + imagen[i][j+1].getR();
                sumR = sumR + imagen[i+1][j-1].getR();sumR = sumR + imagen[i+1][j].getR();
                sumR = sumR + imagen[i+1][j+1].getR();
                sumG = sumG + imagen[i-1][j-1].getG();sumG = sumG + imagen[i-1][j].getG();
                sumG = sumG + imagen[i-1][j+1].getG();sumG = sumG + imagen[i][j-1].getG();
                sumG = sumG + imagen[i][j].getG();sumG = sumG + imagen[i][j+1].getG();
                sumG = sumG + imagen[i+1][j-1].getG();sumG = sumG + imagen[i+1][j].getG();
                sumG = sumG + imagen[i+1][j+1].getG();
                sumB = sumB + imagen[i-1][j-1].getB();sumB = sumB + imagen[i-1][j].getB();
                sumB = sumB + imagen[i-1][j+1].getB();sumB = sumB + imagen[i][j-1].getB();
                sumB = sumB + imagen[i][j].getB();sumB = sumB + imagen[i][j+1].getB();
                sumB = sumB + imagen[i+1][j-1].getB();sumB = sumB + imagen[i+1][j].getB();
                sumB = sumB + imagen[i+1][j+1].getB();
                mediaR=sumR/9;
                mediaG=sumG/9;
                mediaB=sumB/9;
                sumR=0; sumG=0; sumB=0;
                graphicsContext.setFill(javafx.scene.paint.Color.web("#"+decHex(mediaR)+
                        decHex(mediaG)+decHex(mediaB)));
                graphicsContext.fillOval(j,i,1,1);
            }
        }
    }
    public void mediana(){
        int vR[] = new int[9];
        int vG[] = new int[9];
        int vB[] = new int[9];
        for (int i=1 ; i<alto-1 ; i++){
            for (int j=1 ; j<ancho-1 ; j++) {
                vR[0] = imagen[i-1][j-1].getR();vR[1] = imagen[i-1][j].getR();
                vR[2] = imagen[i-1][j+1].getR();vR[3] = imagen[i][j-1].getR();
                vR[4] = imagen[i][j].getR();vR[5] = imagen[i][j+1].getR();
                vR[6] = imagen[i+1][j-1].getR();vR[7] = imagen[i+1][j].getR();
                vR[8] = imagen[i+1][j+1].getR();

                vG[0] = imagen[i-1][j-1].getG();vG[1] = imagen[i-1][j].getG();
                vG[2] = imagen[i-1][j+1].getG();vG[3] = imagen[i][j-1].getG();
                vG[4] = imagen[i][j].getG();vG[5] = imagen[i][j+1].getG();
                vG[6] = imagen[i+1][j-1].getG();vG[7] = imagen[i+1][j].getG();
                vG[8] = imagen[i+1][j+1].getG();

                vB[0] = imagen[i-1][j-1].getB();vB[1] = imagen[i-1][j].getB();
                vB[2] = imagen[i-1][j+1].getB();vB[3] = imagen[i][j-1].getB();
                vB[4] = imagen[i][j].getB();vB[5] = imagen[i][j+1].getB();
                vB[6] = imagen[i+1][j-1].getB();vB[7] = imagen[i+1][j].getB();
                vB[8] = imagen[i+1][j+1].getB();
                vR = ordenarVector(vR);
                vG = ordenarVector(vG);
                vB = ordenarVector(vB);
                graphicsContext.setFill(javafx.scene.paint.Color.web("#"+decHex(vR[4])
                        +decHex(vG[4])+decHex(vB[4])));
                graphicsContext.fillOval(j,i,1,1);
            }
        }
    }
    private int[] ordenarVector(int[] vector){
        int temp;
        for (int x=0 ; x<vector.length ; x++) {
            for (int i=0 ; i<vector.length-x-1 ; i++) {
                if(vector[i] < vector[i+1]){
                    temp = vector[i+1];
                    vector[i+1] = vector[i];
                    vector[i] = temp;
                }
            }
        }
        return vector;
    }
    public void sobel(){
        int[][] edgeColors = new int[alto][ancho];
        int maxGradient = -1;
        int gx,gy;
        for (int i = 1; i < alto - 1; i++) {
            for (int j = 1; j < ancho - 1; j++) {

                gx =  ((-1 * imagen[i-1][j-1].getGris()) + (0 * imagen[i][j-1].getGris()) + (1 * imagen[i+1][j-1].getGris()))
                        + ((-2 * imagen[i-1][j].getGris()) + (0 * imagen[i][j].getGris()) + (2 * imagen[i+1][j].getGris()))
                        + ((-1 * imagen[i-1][j+1].getGris()) + (0 * imagen[i][j+1].getGris()) + (1 * imagen[i+1][j+1].getGris()));

                gy =  ((-1 * imagen[i-1][j-1].getGris()) + (-2 * imagen[i][j-1].getGris()) + (-1 * imagen[i+1][j-1].getGris()))
                        + ((0 * imagen[i-1][j].getGris()) + (0 * imagen[i][j].getGris()) + (0 * imagen[i+1][j].getGris()))
                        + ((1 * imagen[i-1][j+1].getGris()) + (2 * imagen[i][j+1].getGris()) + (1 * imagen[i+1][j+1].getGris()));

                double gval = Math.sqrt((gx * gx) + (gy * gy));
                int g = (int) gval;

                if(maxGradient < g)
                    maxGradient = g;

                edgeColors[i][j] = g;
            }
        }
        double scale = 255.0 / maxGradient;
        for (int i = 1; i < alto - 1; i++) {
            for (int j = 1; j < ancho - 1; j++) {
                int edgeColor = edgeColors[i][j];
                edgeColor = (int)(edgeColor * scale);
                Color color = new Color(edgeColor);
                graphicsContext.setFill(javafx.scene.paint.Color.web("#"+decHex(color.getRed())
                        +decHex(color.getGreen())+decHex(color.getBlue())));
                graphicsContext.fillOval(j,i,1,1);
            }
        }
        reestablecerImagen();
    }
    /*El algoritmo de roberts es mediante el uso de la matriz
    * y consiste en sacar el valor absoluto entre dos valores, es decir,
    * se toma una matriz de 3x3 en la matriz de la imagen donde en esta parte
    * el valor
    * [1,0] = [0,0]-[2,0]
    * [1,1] = [0,1]-[2,1]
    * [1,2] = [0,2]-[2,2]
    * [0,0] = [0,1]-[1,0]
    * [0,2] = [0,1]-[1,2]
    * [2,0] = [1,0]-[2,1]
    * [2,2] = [1,2]-[1,2]
    * [0,1] = [0,0]-[0,2]
    * [2,1] = [2,0]-[2,2]*/
    public void roberts(){
        int r,g,b;
        for (int i=1 ; i<alto-1 ; i++){
            for (int j=1 ; j<ancho-1 ; j++) {
                r = (Math.abs(imagen[i-1][j-1].getR()-imagen[i+1][j+1].getR())+
                        Math.abs(imagen[i-1][j+1].getR()-imagen[i+1][j-1].getR())+
                        Math.abs(imagen[i][j-1].getR()-imagen[i][j+1].getR())+
                        Math.abs(imagen[i-1][j].getR()-imagen[i+1][j].getR()))/4;
                g = (Math.abs(imagen[i-1][j-1].getG()-imagen[i+1][j+1].getG())+
                        Math.abs(imagen[i-1][j+1].getG()-imagen[i+1][j-1].getG())+
                        Math.abs(imagen[i][j-1].getG()-imagen[i][j+1].getG())+
                        Math.abs(imagen[i-1][j].getG()-imagen[i+1][j].getG()))/4;
                b = (Math.abs(imagen[i-1][j-1].getB()-imagen[i+1][j+1].getB())+
                        Math.abs(imagen[i-1][j+1].getB()-imagen[i+1][j-1].getB())+
                        Math.abs(imagen[i][j-1].getB()-imagen[i][j+1].getB())+
                        Math.abs(imagen[i-1][j].getB()-imagen[i+1][j].getB()))/4;
                graphicsContext.setFill(javafx.scene.paint.Color.web("#"+decHex(r)+
                        decHex(g)+decHex(b)));
                graphicsContext.fillOval(j,i,1,1);
            }
        }
    }
    private String decHex(int n){
        if (n<=15)
            return "0"+Integer.toHexString(n);
        else
            return Integer.toHexString(n);
    }
    private void reestablecerImagen(){
        for (int i=0 ; i<alto ; i++){
            for (int j=0 ; j<ancho ; j++){
                imagen[i][j].setR(imagenBackup[i][j].getR());
                imagen[i][j].setG(imagenBackup[i][j].getG());
                imagen[i][j].setB(imagenBackup[i][j].getB());
                imagen[i][j].setGris(imagenBackup[i][j].getGris());
            }
        }
    }
}