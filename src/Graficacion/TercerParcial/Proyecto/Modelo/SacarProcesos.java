package Graficacion.TercerParcial.Proyecto.Modelo;

import Graficacion.TercerParcial.Proyecto.Controlador.VentanaCronometro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;
import java.util.Calendar;

public class SacarProcesos extends Thread
{
    private ProgressBar progressBar;
    private ColaProcesos colaProcesos;
    private ListaOrdenadaProcesos listaOrdenadaProcesos;
    private String politica;
    private RandomAccessFile randomAccessFile;
    private Proceso proceso;
    private GraphicsContext lapiz;
    private double avance,avanceProceso;
    private VentanaCronometro ventanaCronometro;

    public SacarProcesos(ProgressBar progressBar,ColaProcesos colaProcesos,
                         ListaOrdenadaProcesos listaOrdenadaProcesos,String politica,
                         GraphicsContext lapiz){
        this.progressBar = progressBar;
        this.colaProcesos = colaProcesos;
        this.listaOrdenadaProcesos = listaOrdenadaProcesos;
        this.politica = politica;
        this.lapiz = lapiz;
        this.ventanaCronometro = new VentanaCronometro();
    }

    @Override
    public void run(){
        try{
            int t = 0;
            randomAccessFile = new RandomAccessFile(new File("procesos.txt"),"rwd");
            randomAccessFile.writeChars("|    PROCESO    |    TIEMPO LLEGADA    |    TIEMPO SALIDA    |    TIEMPO EN SISTEMA    |\n\n");
            proceso = (politica.equals("FIFO"))?colaProcesos.sacarProceso():listaOrdenadaProcesos.eliminarProcesoLSO();
            while(proceso!=null){
                avance=0;avanceProceso= (1.0/proceso.getTiempo());
                proceso.setHoraLlegada();
                randomAccessFile.writeChars("|    P"+proceso.getIdProceso()+"    |    "+proceso.getHoraLlegada().get(Calendar.HOUR_OF_DAY)+":"+
                                                                                            proceso.getHoraLlegada().get(Calendar.MINUTE)+":"+
                                                                                            proceso.getHoraLlegada().get(Calendar.SECOND)+"    |");
                for (int i=1;i<=proceso.getTiempo();i++){
                    progressBar.setProgress(avance);
                    Thread.sleep(1000);
                    t++;
                    ventanaCronometro.change(t);
                    avance = avance + avanceProceso;
                }
                proceso.setHoraSalida();
                randomAccessFile.writeChars("    "+proceso.getHoraSalida().get(Calendar.HOUR_OF_DAY)+":"+
                                                    proceso.getHoraSalida().get(Calendar.MINUTE)+":"+
                                                    proceso.getHoraSalida().get(Calendar.SECOND)+"    |    "+proceso.getTiempo()+"    |\n");
                dibujarSalidaProceso();
                proceso = (politica.equals("FIFO"))?colaProcesos.sacarProceso():listaOrdenadaProcesos.eliminarProcesoLSO();
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dibujarSalidaProceso(){
        int y = proceso.getCoordenada();
        for (int i=100 ; i<=300 ; i++){
            for (int j=y ; j<y+proceso.getTiempo() ; j++){
                lapiz.clearRect(i,j,1,1);
            }
        }
    }
}