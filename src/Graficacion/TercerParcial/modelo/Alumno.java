package Graficacion.TercerParcial.modelo;

public class Alumno
{
    private int turno;
    private String noControl;
    private String nombre;
    private int semestre;
    private double promedio;
    private Caracteristicas caracteristicas;

    public Alumno(int turno,String noControl, String nombre, int semestre, double promedio) {
        this.turno = turno;
        this.noControl = noControl;
        this.nombre = nombre;
        this.semestre = semestre;
        this.promedio = promedio;
        this.caracteristicas = new Caracteristicas();
    }

    public Alumno(int turno, String noControl, String nombre, int semestre) {
        this.turno = turno;
        this.noControl = noControl;
        this.nombre = nombre;
        this.semestre = semestre;
        this.caracteristicas = new Caracteristicas();
    }
    public Alumno(String nombre){
        this.nombre = nombre;
    }

    public Alumno(){ }

    public void setTurno(int turno){ this.turno = turno; }
    public void setNoControl(String noControl) { this.noControl = noControl; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
    public void setCaracteristicas(Caracteristicas caracteristicas){ this.caracteristicas = caracteristicas; }

    public int getTurno(){ return this.turno; }
    public String getNoControl() { return this.noControl; }
    public String getNombre() { return this.nombre; }
    public int getSemestre() { return this.semestre; }
    public double getPromedio() { return this.promedio; }
    public Caracteristicas getCaracteristicas(){ return this.caracteristicas; }
}