package Graficacion.TercerParcial.Proyecto.Modelo;

import java.util.Calendar;

public class Proceso
{
    private int idProceso;
    private int tiempo;
    private String color;
    private int coordenada;
    private Calendar horaLlegada;
    private Calendar horaSalida;

    public Proceso(int idProceso){
        this.idProceso = idProceso;
        this.tiempo = (int) (Math.random()*20)+10;
        this.color = decHex((int)(Math.random()*255))+decHex((int)(Math.random()*255))+decHex((int)(Math.random()*255));
    }

    public int getIdProceso(){ return idProceso; }
    public int getTiempo(){ return tiempo; }
    public String getColor(){ return color; }
    public int getCoordenada(){ return coordenada; }
    public Calendar getHoraLlegada(){ return horaLlegada; }
    public Calendar getHoraSalida(){ return horaSalida; }

    public void setIdProceso(int idProceso) { this.idProceso = idProceso; }
    public void setTiempo(int tiempo) { this.tiempo = tiempo; }
    public void setColor(String color) { this.color = color; }
    public void setCoordenada(int coordenada){ this.coordenada = coordenada; }
    public void setHoraLlegada() { this.horaLlegada = Calendar.getInstance(); }
    public void setHoraSalida() { this.horaSalida = Calendar.getInstance(); }


    private String decHex(int n){
        if (n<=15)
            return "0"+Integer.toHexString(n);
        else
            return Integer.toHexString(n);
    }
}
