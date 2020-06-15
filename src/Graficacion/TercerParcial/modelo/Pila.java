package Graficacion.TercerParcial.modelo;

public class Pila
{
    private NodoGeneral inicio;

    public Pila(){
        this.inicio = null;
    }

    public void meterObject(Object object){
        NodoGeneral nuevo;
        if (inicio==null)
            inicio = new NodoGeneral(object);
        else{
            nuevo = new NodoGeneral(object,inicio);
            inicio = nuevo;
        }
    }
    public Object sacarObject(){
        Object aux;
        if(inicio!=null){
            aux = inicio.getObject();
            inicio = inicio.getNodoSiguiente();
            return aux;
        }else{
            return null;
        }
    }
}
