package Graficacion.TercerParcial.modelo;

public class Libro
{
    private String cveLibro,nombre,autor;
    private int year;
    double peso;

    public Libro(String cveLibro, String nombre, String autor, int year, double peso) {
        this.cveLibro = cveLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.year = year;
        this.peso = peso;
    }
    public Libro(){
    }

    public String getCveLibro() { return cveLibro; }
    public String getNombre() { return nombre; }
    public String getAutor() { return autor; }
    public int getYear() { return year; }
    public double getPeso() { return peso; }

    public void setCveLibro(String cveLibro) { this.cveLibro = cveLibro; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setYear(int year) { this.year = year; }
    public void setPeso(double peso) { this.peso = peso; }
}