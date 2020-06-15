package Graficacion.TercerParcial.controlador;

import Graficacion.TercerParcial.modelo.Alumno;
import Graficacion.TercerParcial.modelo.Cola;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerColaServiciosEscolares implements Initializable
{
    @FXML private Button btnLlega,btnAtender;
    @FXML private Canvas lienzo;
    private GraphicsContext lapiz;
    private Cola colaAlumnos;
    private Cola colaTemp;
    private Alumno alumno;
    private int posTemp;
    private int turno;
    private int y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lapiz = lienzo.getGraphicsContext2D();
        colaAlumnos = new Cola();
        colaTemp = new Cola();
        turno = 0;
        btnAtender.setOnAction(event -> eventos(1));
        btnLlega.setOnAction(event -> eventos(0));
    }
    private void eventos(int opcion){
        if (opcion==0){//Llega Alumno
            alumno = new Alumno(turno,JOptionPane.showInputDialog("noControl"),
                    JOptionPane.showInputDialog("nombre"),
                    Integer.parseInt(JOptionPane.showInputDialog("Semestre")));
            colaAlumnos.insertarObject(alumno);
            turno=turno+1;
            llegaAlumno();
        }if (opcion==1){
            turno = 0;
            alumno = (Alumno)colaAlumnos.quitarObject();
            if (alumno!=null){
                JOptionPane.showMessageDialog(null,"Turno de atender al alumno "+alumno.getNombre()+"\ncon NoControl "+alumno.getNoControl()+"\nde semestre "+alumno.getSemestre(),"Turno de",JOptionPane.INFORMATION_MESSAGE);
                saleAlumno();
                alumno = (Alumno)colaAlumnos.quitarObject();
                while(alumno!=null){
                    saleAlumno();
                    alumno.setTurno(turno);
                    colaTemp.insertarObject(alumno);
                    llegaAlumno();
                    alumno=(Alumno)colaAlumnos.quitarObject();
                    turno++;
                }
                alumno = (Alumno)colaTemp.quitarObject();
                while(alumno!=null){
                    colaAlumnos.insertarObject(alumno);
                    alumno = (Alumno) colaTemp.quitarObject();
                }
            }
        }
    }
    private void llegaAlumno(){
        lapiz.setFill(Color.web(alumno.getCaracteristicas().getColor()));
        posTemp = (alumno.getTurno()*40) + 20;
        //DibujarCabeza
        for (int x=1 ; x<=39 ; x++){
            y =(int) Math.sqrt(400-((x-20)*(x-20)));
            lapiz.fillRect(posTemp-20+x,170-y,2,2);
            lapiz.fillRect(posTemp-20+x,y+170,2,2);
        }
        //DibujarCuerpo
        for (int h=190 ; h<=230 ; h++){
            lapiz.fillRect(posTemp,h,2,2);
        }
        //DibujarPiernas
        for(int pie=4 ; pie<=36 ; pie++){
            lapiz.fillRect(posTemp-20+pie,(pie<=20)?-pie+250:pie+210,2,2);
        }
        //DibujarOjoS
        for (int ojo=0 ; ojo<=8 ; ojo++) {
            lapiz.fillRect(posTemp-10+ojo,165,2,2);
            lapiz.fillRect(posTemp+10-ojo,165,2,2);
        }
        //DibujarCaracateristicasEspeciales
        if (alumno.getCaracteristicas().getModo()>=0 && alumno.getCaracteristicas().getModo()<10){
            for (int lentes=0 ; lentes<=8 ; lentes++) {
                for (int lentes2=162 ; lentes2<170 ; lentes2++){
                    lapiz.fillRect(posTemp-10+lentes,lentes2,2,2);
                    lapiz.fillRect(posTemp+10-lentes,lentes2,2,2);
                }
            }
            for(int mano=posTemp-15 ; mano<=posTemp+15 ; mano++){
                lapiz.fillRect(mano,200,2,2);
            }
            for (int boca=0 ; boca<=20 ; boca++) {
                lapiz.fillRect(posTemp-10+boca,180,2,2);
            }
            for (int baston=200 ; baston<250 ; baston++){
                lapiz.fillRect(posTemp-15,baston,2,2);
            }
        }
        if (alumno.getCaracteristicas().getModo()>=10 && alumno.getCaracteristicas().getModo()<20){
            for (int afro=1 ; afro<=39 ; afro++){
                y =(int) Math.sqrt(400-((afro-20)*(afro-20)));
                for (int afro2 = 170; afro2>155 ; afro2--) {
                    lapiz.fillRect(posTemp-20+afro,afro2-y,2,2);
                }
            }
            for(int mano=4 ; mano<=36 ; mano++){
                lapiz.fillRect(posTemp-20+mano,(mano<=20)?-mano+220:mano+180,2,2);
            }
            for (int boca=1 ; boca<=19 ; boca++) {
                y =(int) Math.sqrt(100-((boca-10)*(boca-10)));
                lapiz.fillRect(posTemp-10+boca,182-y,2,2);
            }
        }
        if (alumno.getCaracteristicas().getModo()>=20 && alumno.getCaracteristicas().getModo()<30){
            for(int mano=4 ; mano<=36 ; mano++){
                lapiz.fillRect(posTemp-20+mano,(mano<=20)?mano+190:-mano+230,2,2);
            }
            for (int boca=1 ; boca<=19 ; boca++) {
                y =(int) Math.sqrt(100-((boca-10)*(boca-10)));
                lapiz.fillRect(posTemp-10+boca,y+175,2,2);
            }
        }
    }
    private void saleAlumno(){
        posTemp = (alumno.getTurno()*40) + 20;
        //QuitarCabeza
        for (int x=1 ; x<=39 ; x++){
            y =(int) Math.sqrt(400-((x-20)*(x-20)));
            lapiz.clearRect(posTemp-20+x,170-y,2,2);
            lapiz.clearRect(posTemp-20+x,y+170,2,2);
        }
        //QuitarCuerpo
        for (int h=190 ; h<=230 ; h++){
            lapiz.clearRect(posTemp,h,2,2);
        }
        //QuitarPiernas
        for(int pie=4 ; pie<=36 ; pie++){
            lapiz.clearRect(posTemp-20+pie,(pie<=20)?-pie+250:pie+210,2,2);
        }
        //QuitarOjoS
        for (int ojo=0 ; ojo<=8 ; ojo++) {
            lapiz.clearRect(posTemp-10+ojo,165,2,2);
            lapiz.clearRect(posTemp+10-ojo,165,2,2);
        }
        //QuitarCaracateristicasEspeciales
        if (alumno.getCaracteristicas().getModo()>=0 && alumno.getCaracteristicas().getModo()<10){
            for (int lentes=0 ; lentes<=8 ; lentes++) {
                for (int lentes2=162 ; lentes2<170 ; lentes2++){
                    lapiz.clearRect(posTemp-10+lentes,lentes2,2,2);
                    lapiz.clearRect(posTemp+10-lentes,lentes2,2,2);
                }
            }
            for(int mano=posTemp-15 ; mano<=posTemp+15 ; mano++){
                lapiz.clearRect(mano,200,2,2);
            }
            for (int boca=0 ; boca<=20 ; boca++) {
                lapiz.clearRect(posTemp-10+boca,180,2,2);
            }
            for (int baston=200 ; baston<250 ; baston++){
                lapiz.clearRect(posTemp-15,baston,2,2);
            }
        }
        if (alumno.getCaracteristicas().getModo()>=10 && alumno.getCaracteristicas().getModo()<20){
            for (int afro=1 ; afro<=39 ; afro++){
                y =(int) Math.sqrt(400-((afro-20)*(afro-20)));
                for (int afro2 = 170; afro2>155 ; afro2--) {
                    lapiz.clearRect(posTemp-20+afro,afro2-y,2,2);
                }
            }
            for(int mano=4 ; mano<=36 ; mano++){
                lapiz.clearRect(posTemp-20+mano,(mano<=20)?-mano+220:mano+180,2,2);
            }
            for (int boca=1 ; boca<=19 ; boca++) {
                y =(int) Math.sqrt(100-((boca-10)*(boca-10)));
                lapiz.clearRect(posTemp-10+boca,182-y,2,2);
            }
        }
        if (alumno.getCaracteristicas().getModo()>=20 && alumno.getCaracteristicas().getModo()<30){
            for(int mano=4 ; mano<=36 ; mano++){
                lapiz.clearRect(posTemp-20+mano,(mano<=20)?mano+190:-mano+230,2,2);
            }
            for (int boca=1 ; boca<=19 ; boca++) {
                y =(int) Math.sqrt(100-((boca-10)*(boca-10)));
                lapiz.clearRect(posTemp-10+boca,y+175,2,2);
            }
        }
    }
}