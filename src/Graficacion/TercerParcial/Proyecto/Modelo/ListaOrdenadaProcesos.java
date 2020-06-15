package Graficacion.TercerParcial.Proyecto.Modelo;

import javax.swing.JOptionPane;

public class ListaOrdenadaProcesos
{
    private NodoProceso inicio;

    public boolean listaVacia() { return inicio == null; }

    public void insertarLSO(Proceso proceso)
    {
        NodoProceso rec,ant,nuevo;
        if(!listaVacia()){
            if(proceso.getTiempo() < inicio.getProceso().getTiempo()){
                inicio = new NodoProceso(proceso,inicio);
            }
            else
            {
                rec = inicio;
                ant = rec;
                while(rec.getProceso().getTiempo() < proceso.getTiempo() && rec.getNodoSiguiente() != null) {
                    ant = rec;
                    rec = rec.getNodoSiguiente();
                }
                if(rec.getProceso().getTiempo() > proceso.getTiempo()) {
                    nuevo = new NodoProceso(proceso,rec);
                    ant.setNodoSiguiente(nuevo);
                }
                else {
                    nuevo = new NodoProceso(proceso);
                    rec.setNodoSiguiente(nuevo);
                }
            }
        }else{
            inicio = new NodoProceso(proceso);
        }

    }

    public Proceso eliminarLSO(int tiempo)
    {
        NodoProceso rec, ant;
        Proceso proceso = null;
        if(!listaVacia()){
            if(tiempo == inicio.getProceso().getTiempo()){
                proceso = inicio.getProceso();
                inicio = inicio.getNodoSiguiente();
            }
            else {
                rec = inicio;
                ant = rec;
                while(rec.getProceso().getTiempo()<tiempo && rec.getNodoSiguiente()!=null) {
                    ant = rec;
                    rec = rec.getNodoSiguiente();
                }
                if (rec.getProceso().getTiempo()==tiempo){
                    proceso = ant.getProceso();
                    ant.setNodoSiguiente(rec.getNodoSiguiente());
                }
            }
        }
        return proceso;
    }

    public Proceso eliminarProcesoLSO(){
        Proceso proceso = null;
        if (!listaVacia()){
            proceso = inicio.getProceso();
            inicio = inicio.getNodoSiguiente();
        }
        return proceso;
    }

    public void mostrarProcesosEnLienzo(){
        NodoProceso rec;
        Proceso procesoTemp;
        if(!listaVacia())
        {
            rec = inicio;
            do {
                procesoTemp = rec.getProceso();
                rec = rec.getNodoSiguiente();
            } while(rec != null);
        }
    }

    public void mostrarLSO()
    {
        NodoProceso rec;
        if(!listaVacia())
        {
            rec = inicio;
            do {
                JOptionPane.showMessageDialog(null,"P"+rec.getProceso().getIdProceso()+"  T = "+rec.getProceso().getTiempo());
                rec = rec.getNodoSiguiente();
            } while(rec != null);
        }
    }
}