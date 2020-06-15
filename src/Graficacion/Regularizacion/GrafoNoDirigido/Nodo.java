package Graficacion.Regularizacion.GrafoNoDirigido;

public class Nodo
{
    private int x,y,valor;

    public Nodo(int valor,int x,int y){
        this.x = x;
        this.y = y;
        this.valor = valor;
    }

    public Nodo(int valor){
        this.valor = valor;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getValor() { return valor; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setValor(int valor) { this.valor = valor; }
}