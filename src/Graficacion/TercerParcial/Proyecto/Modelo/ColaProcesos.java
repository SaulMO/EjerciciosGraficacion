package Graficacion.TercerParcial.Proyecto.Modelo;

public class ColaProcesos
{
    private NodoProceso inicio;

    public ColaProcesos() { inicio = null; }

    public void entraProceso(Proceso proceso)
    {
        NodoProceso recorre,nuevo;
        if(inicio == null){
            inicio = new NodoProceso(proceso);
        }
        else {
            nuevo = new NodoProceso(proceso);
            recorre = inicio;
            while(recorre.getNodoSiguiente() != null) {
                recorre = recorre.getNodoSiguiente();
            }
            recorre.setNodoSiguiente(nuevo);
        }
    }

    public Proceso sacarProceso(){
        Proceso proceso = null;
        if(inicio != null) {
            proceso = inicio.getProceso();
            inicio = inicio.getNodoSiguiente();
        }
        return proceso;
    }
}