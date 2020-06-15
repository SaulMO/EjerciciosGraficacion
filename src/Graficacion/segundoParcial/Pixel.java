package Graficacion.segundoParcial;

public class Pixel
{
    private int r,g,b,gris;
    public Pixel(int r,int g,int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public Pixel(int r,int g,int b,int gris){
        this.r = r;
        this.g = g;
        this.b = b;
        this.gris = gris;
    }

    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }
    public int getGris() { return gris; }
    public String getPixelGris(){ return decHex(gris);}
    public String getRHex(){ return decHex(r);}
    public String getGHex(){ return decHex(g);}
    public String getBHex(){ return decHex(b);}
    public String getGrisHex(){ return decHex(gris); }
    public void setR(int r) { this.r = r; }
    public void setG(int g) { this.g = g; }
    public void setB(int b) { this.b = b; }
    public void setGris(int gris) { this.gris = gris; }
    private String decHex(int n){
        if (n<=15)
            return "0"+Integer.toHexString(n);
        else
            return Integer.toHexString(n);
    }
}