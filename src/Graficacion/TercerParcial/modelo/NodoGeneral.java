package Graficacion.TercerParcial.modelo;

public class NodoGeneral
{
    private Object object;
    private NodoGeneral nodoSiguiente;

    public NodoGeneral(Object object){
        this.object = object;
        this.nodoSiguiente = null;
    }
    public NodoGeneral(Object object, NodoGeneral nodoSiguiente){
        this.object = object;
        this.nodoSiguiente = nodoSiguiente;
    }

    public Object getObject(){ return this.object; }
    public NodoGeneral getNodoSiguiente(){ return nodoSiguiente; }
    public void setNodoSiguiente(NodoGeneral nodoSiguiente){ this.nodoSiguiente = nodoSiguiente; }
}