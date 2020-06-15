package Graficacion.TercerParcial.modelo;

public class Caracteristicas
{
    private int modo;
    private String color;

    public Caracteristicas(){
        this.modo = (int) (Math.random()*30);
        this.color = decHex((int)(Math.random()*255))+decHex((int)(Math.random()*255))+decHex((int)(Math.random()*255));
    }
    public String getColor(){
        return this.color;
    }
    public int getModo(){ return this.modo; }

    private String decHex(int n){
        if (n<=15)
            return "0"+Integer.toHexString(n);
        else
            return Integer.toHexString(n);
    }
}