package Graficacion.Regularizacion.Arbol;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol
{
    NodoArbol nodoRaiz;
    int nivelArbol=0,valor;

    public Arbol(){
        nodoRaiz = null;
    }
    public boolean arbolVacio(){
        return nodoRaiz == null;
    }
    public NodoArbol insertarDato(int dato){
        NodoArbol recorre,anterior = null;
        NodoArbol nodoArbol = null;
        nivelArbol = 0;
        boolean insertaDato = true;
        valor = 650;
        if (arbolVacio()){
            nodoArbol = new NodoArbol(dato,valor,0);
            nodoRaiz = nodoArbol;
        }
        else{
            recorre = nodoRaiz;
            while(recorre!=null && insertaDato){
                nivelArbol = nivelArbol+1;
                anterior = recorre;
                if (recorre.getInfo()<dato){
                    recorre = recorre.getNodoDer();
                }else if (recorre.getInfo()>dato){
                    recorre = recorre.getNodoIzq();
                }else{
                    insertaDato = false;
                }
            }
            for (int i=0; i<nivelArbol ; i++) {
                valor = valor/2;
            }
            if (anterior.getInfo()<dato){
                nodoArbol = new NodoArbol(dato,anterior.getCoordenadaX()+valor,anterior.getCoordenadaY()+50);
                anterior.setNodoDer(nodoArbol);
            } else if (anterior.getInfo()>dato){
                nodoArbol = new NodoArbol(dato,anterior.getCoordenadaX()-valor,anterior.getCoordenadaY()+50);
                anterior.setNodoIzq(nodoArbol);
            }
        }
        return nodoArbol;
    }
    public Queue<NodoArbol> getCamino(int info){
        Queue<NodoArbol> queueRecorrido = new LinkedList<NodoArbol>();
        NodoArbol recorre,anterior = null;
        recorre = nodoRaiz;
        queueRecorrido.add(nodoRaiz);
        boolean seEncontroNodo = false;
        while(recorre!=null && !seEncontroNodo){
            queueRecorrido.add(recorre);
            anterior = recorre;
            if (recorre.getInfo()<info){
                recorre = recorre.getNodoDer();
            }else if (recorre.getInfo()>info) {
                recorre = recorre.getNodoIzq();
            }else if (recorre.getInfo()==info)
                seEncontroNodo = true;
        }
        if (!seEncontroNodo)
            System.out.println("No se encontro ese nodo");
        return queueRecorrido;
    }

}