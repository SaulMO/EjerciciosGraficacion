package Graficacion.TercerParcial.modelo;

public class Materia
{
    private int creditos;
    private String nombre;

    public Materia(int creditos, String nombre) {
        this.creditos = creditos;
        this.nombre = nombre;
    }
    public Materia(String nombre) {
        this.creditos = creditos;
        this.nombre = nombre;
    }

    public int getCreditos() { return creditos; }
    public String getNombre() { return nombre; }

    public void setCreditos(int creditos) { this.creditos = creditos; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}