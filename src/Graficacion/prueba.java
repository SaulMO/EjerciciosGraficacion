package Graficacion;

import Graficacion.TercerParcial.modelo.Lista;

public class prueba
{
    public static void main(String[] args){
        Lista lista = new Lista();


        lista.insertarLSD(1);
        lista.insertarLSD(2);
        lista.insertarLSD(3);
        lista.insertarLSD(4);
        lista.insertarLSD(5);
        lista.insertarLSD(6);
        lista.insertarLSD(7);

        lista.eliminarLSD(3);

        lista.mostrarLSD();
    }
}