package Graficacion.TercerParcial.modelo;

public class Cola
{
    private NodoGeneral Inicio;

    public Cola() {
        Inicio = null;
    }

    public void insertarObject(Object object)
    {
        NodoGeneral recorre,nuevo;
        if(Inicio == null)
            Inicio = new NodoGeneral(object);
        else {
            nuevo = new NodoGeneral(object);
            recorre = Inicio;
            while(recorre.getNodoSiguiente() != null) {
                recorre = recorre.getNodoSiguiente();
            }
            recorre.setNodoSiguiente(nuevo);
        }
    }

    public Object quitarObject(){
        Object Aux = null;

        if(Inicio != null) {
            Aux = Inicio.getObject();
            Inicio = Inicio.getNodoSiguiente();
            return Aux;
        }
        return Aux;
    }
}