package Graficacion.TercerParcial.modelo;

public class NodoMaterias
{
    private int noMateria;
    private NodoMaterias nodoSiguiente;

    public NodoMaterias(int noMateria){
        this.noMateria = noMateria;
        this.nodoSiguiente = null;
    }
    public NodoMaterias(int noMateria, NodoMaterias nodoSiguiente){
        this.noMateria = noMateria;
        this.nodoSiguiente = nodoSiguiente;
    }

    public int getMateria(){ return this.noMateria; }
    public NodoMaterias getNodoSiguiente(){ return nodoSiguiente; }
    public void setNodoSiguiente(NodoMaterias nodoSiguiente){ this.nodoSiguiente = nodoSiguiente; }
}