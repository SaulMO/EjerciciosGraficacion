package Graficacion.TercerParcial.modelo;

import javax.swing.*;

public class Lista
{
    NodoMaterias Inicio;
    public Lista()
    {
        Inicio = null;
    }
    public boolean listaVacia()
    {
        return Inicio == null;
    }
    public void insertarLSD(int materia)
    {
        Inicio = new NodoMaterias(materia, Inicio);
    }
    public void eliminarLSD(int materia)
    {
        NodoMaterias Rec, Ant;
        if(!listaVacia())
            if(Inicio.getMateria() == materia)
                if(Inicio.getNodoSiguiente() == null)
                    Inicio = null;
                else
                    Inicio = Inicio.getNodoSiguiente();
            else
            {
                Rec = Inicio;
                Ant = Rec;
                while(Rec.getMateria() != materia && Rec.getNodoSiguiente() != null)
                {
                    Ant = Rec;
                    Rec = Rec.getNodoSiguiente();
                }
                if(Rec.getMateria() == materia)
                    Ant.setNodoSiguiente(Rec.getNodoSiguiente());;
            }
    }

    public void mostrarLSD()
    {
        NodoMaterias Rec;
        if(!listaVacia())
        {
            Rec = Inicio;
            do
            {
                JOptionPane.showMessageDialog(null,""+Rec.getMateria());
                Rec = Rec.getNodoSiguiente();
            } while(Rec != null);
        }
    }
}