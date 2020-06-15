package Graficacion.segundoParcial.RetosProgramacion;

import javax.swing.*;
import java.util.ArrayList;

/*
* La Pareja Mas Cercana
*
* Dada una lista de números enteros positivos que puede contener desde 5 hasta 1000 elementos,
* por ejemplo(4,6,1,90,56,4379,53) se desea saber cuales de ellos son los más cercanos, cuáles
* dos de ellos son los más cercanos en valor, es decir, que e valor absoluto de su diferencia
* sea menor que el de cualquier otra pareja de números en la lista. Para la lista anterior,
* la pareja más cercana son 4 y 6, ya que ningún otro par de números tiene una resta cuyo
* valor absoluto sea menor a 2 (6-4=2). Escribe de la manera más eficiente posible, un algoritmo
* que permita, mediante el uso de una computadora obtener la pareja mas cercana de una lista dada*/

public class Programa1
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null,"La Pareja Más Cercana:\n\nDada una lista de números enteros positivos que puede contener desde 5 hasta 1000 elementos,\n" +
                "por ejemplo(4,6,1,90,56,4379,53) se desea saber cuales de ellos son los más cercanos, cuáles\n" +
                "dos de ellos son los más cercanos en valor, es decir, que e valor absoluto de su diferencia\n" +
                "sea menor que el de cualquier otra pareja de números en la lista. Para la lista anterior,\n" +
                "la pareja más cercana son 4 y 6, ya que ningún otro par de números tiene una resta cuyo\n" +
                "valor absoluto sea menor a 2 (6-4=2). Escribe de la manera más eficiente posible, un algoritmo\n" +
                "que permita, mediante el uso de una computadora obtener la pareja mas cercana de una lista dada");
        /*Crear una lista que guarde todos los datos a comparar*/
        ArrayList<Integer> lista = new ArrayList<>();
        String valor = null;
        /*Ciclo donde guardamos todos los datos a comparar*/
        do{
            try{
                valor = JOptionPane.showInputDialog("Teclee entero positivo que pertenecera a vector");
                lista.add(Integer.parseInt(valor));
            }catch (NumberFormatException nfe){
            }
        }while(valor != null);
        /*decision donde condicionamos que la lista sea mayoro igual que 2 ya que al ser menor que 2
        * no podria haber comparasion entre dos valoers*/
        if (lista.size()>=2){
            /*Variable valorA que guarda el primer valor de la lista
            * Variable valorB que guarda el segundo valor de la lista
            * Variable dif que guarda la diferencia menor que existe entre dos valores
            * Variable difTemp que va cambiando de acuerdo cambia el valor B*/
            int valorA=lista.get(0) , valorB=lista.get(1) , dif,difTemp;
            dif = Math.abs(valorA-valorB);
            difTemp=dif;

            /*Ciclo que recorre toda la lista*/
            for (int i=0 ; i<lista.size() ; i++){
                /*Ciclo anidado dentro que recorre toda la lista, este ciclo hace lo mismo
                * donde estos se usan para comparar la distancia de un valor entre
                * todos los otros valores estas diferencias se van comparando entre la variable
                * dif y difTemp, donde difTemp es la que siempre cambia*/
                for (int j=0 ; j<lista.size() ; j++){
                    if (i!=j)
                        difTemp = Math.abs(lista.get(i)-lista.get(j));
                    if (difTemp<dif){
                        dif = difTemp;
                        valorA = lista.get(i);
                        valorB = lista.get(j);
                    }
                }
            }
            /*Al final se imprime el resultado de valorA y valorB*/
            JOptionPane.showMessageDialog(null,"Menor Diferencia (a="+valorA+",b="+valorB+") = "+dif);
        }
    }
}