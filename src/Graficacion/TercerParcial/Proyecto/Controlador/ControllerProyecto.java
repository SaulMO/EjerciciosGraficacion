package Graficacion.TercerParcial.Proyecto.Controlador;

import Graficacion.TercerParcial.Proyecto.Modelo.ColaProcesos;
import Graficacion.TercerParcial.Proyecto.Modelo.ListaOrdenadaProcesos;
import Graficacion.TercerParcial.Proyecto.Modelo.Proceso;
import Graficacion.TercerParcial.Proyecto.Modelo.SacarProcesos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerProyecto implements Initializable
{
    @FXML private Button btnLlega,btnSimular;
    @FXML private ComboBox<String> cbPolitica;
    @FXML private Canvas lienzo;
    @FXML private TextArea txtProcesos;
    @FXML private Label lblInfo,lblTiempo;
    @FXML private ProgressBar progreso;
    private int idProceso;
    private GraphicsContext lapiz;
    private ColaProcesos colaProcesos;
    private ListaOrdenadaProcesos listaProcesos;
    private Proceso procesoTemp;
    private int contLugar;
    private SacarProcesos hiloSacarProcesos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbPolitica.getItems().addAll("FIFO","ListaOrdenada");
        cbPolitica.setValue("FIFO");
        btnLlega.setOnAction(event -> llegaProceso());
        btnSimular.setOnAction(event -> simularScheduler());
        colaProcesos = new ColaProcesos();
        listaProcesos = new ListaOrdenadaProcesos();
        idProceso = 0;
        contLugar = 0;
        lapiz = lienzo.getGraphicsContext2D();
        progreso.setProgress(0);
    }
    private void llegaProceso(){
        cbPolitica.setDisable(true);
        procesoTemp = new Proceso(idProceso);
        procesoTemp.setCoordenada(contLugar);
        dibujarLlegadaProceso();
        contLugar = contLugar+procesoTemp.getTiempo();
        idProceso++;
        lblInfo.setText("Politica : "+cbPolitica.getValue());
        if (cbPolitica.getValue().equals("FIFO")){
            colaProcesos.entraProceso(procesoTemp);
        }else if(cbPolitica.getValue().equals("ListaOrdenada")){
            listaProcesos.insertarLSO(procesoTemp);
        }
    }
    private void simularScheduler(){
        hiloSacarProcesos = new SacarProcesos(progreso,colaProcesos,listaProcesos,
                cbPolitica.getValue(),lapiz);
        hiloSacarProcesos.start();
    }
    private void dibujarLlegadaProceso(){
        lapiz.setFill(Color.web(procesoTemp.getColor()));
        int y = procesoTemp.getCoordenada();
        for (int i=100 ; i<=300 ; i++){
            for (int j=y ; j<y+procesoTemp.getTiempo() ; j++){
                lapiz.fillRect(i,j,1,1);
            }
        }
        txtProcesos.appendText("P"+procesoTemp.getIdProceso()+"\t\tcon tiempo="+procesoTemp.getTiempo()+"\n");
    }
    public void cambiarTiempo(int t){
        lblTiempo.setText(String.valueOf(t));
    }
}