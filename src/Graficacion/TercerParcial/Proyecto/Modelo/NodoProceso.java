package Graficacion.TercerParcial.Proyecto.Modelo;

public class NodoProceso
{
    private Proceso proceso;
    private NodoProceso nodoSiguiente;

    public NodoProceso(Proceso proceso){
        this.proceso = proceso;
        this.nodoSiguiente = null;
    }
    public NodoProceso(Proceso proceso, NodoProceso nodoSiguiente){
        this.proceso = proceso;
        this.nodoSiguiente = nodoSiguiente;
    }

    public Proceso getProceso(){ return this.proceso; }
    public NodoProceso getNodoSiguiente(){ return nodoSiguiente; }
    public void setNodoSiguiente(NodoProceso nodoSiguiente){ this.nodoSiguiente = nodoSiguiente; }
}