package Graficacion.Regularizacion.Arbol;

public class NodoArbol
{
    private int info,x,y;
    private NodoArbol nodoIzq,nodoDer;
    public NodoArbol(int info,int x,int y){
        this.info = info;
        this.x = x;
        this.y = y;
        this.nodoIzq = null;
        this.nodoDer = null;
    }
    public int getInfo(){ return info; }
    public NodoArbol getNodoIzq(){ return nodoIzq; }
    public NodoArbol getNodoDer(){ return nodoDer; }
    public int getCoordenadaX(){ return x; }
    public int getCoordenadaY(){ return y; }
    public void setInfo(int info){ this.info = info; }
    public void setNodoIzq(NodoArbol nodoIzq){ this.nodoIzq = nodoIzq; }
    public void setNodoDer(NodoArbol nodoDer){ this.nodoDer = nodoDer; }
    public void setCoordenadaX(int x){ this.x=x; }
    public void setCoordenadaY(int y){ this.y = y; }
}