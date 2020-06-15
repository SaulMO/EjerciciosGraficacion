package Graficacion.segundoParcial.RetosProgramacion;

/*
* La Distancia Más Corta
*
* Problema similar al programa 1 a excepción que ahora en lugar de números se tiene una lista sobre plano.
* El número de puntos en el plano puede ser hasta 10000. Escribe un algoritmo que mediante el uso de una
* computadora encuentre la pareja de puntos mas cercana, es decir, que la distancia entre ambos puntos sea
* menor que para cualquier otra pareja de puntos de la lista*/

import javax.swing.*;
import java.util.ArrayList;

public class Programa2
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null,"La Distancia Mas Corta\n\n" +
                "Problema similar al programa 1 a excepción que ahora en lugar de números se tiene una lista sobre plano.\n" +
                "El número de puntos en el plano puede ser hasta 10000. Escribe un algoritmo que mediante el uso de una\n" +
                "computadora encuentre la pareja de puntos mas cercana, es decir, que la distancia entre ambos puntos sea\n" +
                "menor que para cualquier otra pareja de puntos de la lista");
        /*Crear una lista que guarde todos los datos a comparar*/
        ArrayList<Punto> puntos = new ArrayList<>();
        String valor = null;
        int coordenada[] = {0,0};
        /*Ciclo donde guardamos el par de puntos para comparar*/
        do{
            valor = JOptionPane.showInputDialog("Teclea una coordenada. Ejem: 1,1");
            if (valor != null){
                coordenada = getCoordenadas(valor);
                puntos.add(new Punto(coordenada[0],coordenada[1]));
            }
        }while(valor != null);
        /*decision donde condicionamos que la lista sea mayoro igual que 2 ya que al ser menor que 2
         * no podria haber comparasion entre dos valoers*/
        if (puntos.size()>=2){
            /*Variable pA que guarda la coordenada del primer punto
             * Variable pB que guarda la coordenada del segundo punto
             * Variable dist que guarda la diferencia menor que existe entre dos puntos
             * Variable difTemp que va cambiando de acuerdo cambia el punto B y la distancia entre estos*/
            Punto pA=puntos.get(0) , pB=puntos.get(1);
            double dis,disTemp;
            dis = Math.sqrt( (Math.pow(pB.getX()-pA.getX(),2)) + (Math.pow(pB.getY()-pA.getY(),2)));
            disTemp=dis;
            /*Ciclo que recorre todas las coordenadas de puntos*/
            for (int i=0 ; i<puntos.size() ; i++){
                /*Ciclo anidado dentro del que recorre todos los puntos, este ciclo hace lo mismo
                 * donde estos se usan para comparar la distancia de un valor entre
                 * todos los otros puntos estas diferencias se van comparando entre la variable
                 * dist y disTemp, donde disTemp es la que siempre cambia*/
                for (int j=0 ; j<puntos.size() ; j++){
                    if (i!=j)
                        disTemp = Math.sqrt( (Math.pow(puntos.get(j).getX()-puntos.get(i).getX(),2)) +
                                (Math.pow(puntos.get(j).getY()-puntos.get(i).getY(),2)));
                    if (disTemp<dis){
                        dis = disTemp;
                        pA = puntos.get(i);
                        pB = puntos.get(j);
                    }
                }
            }
            JOptionPane.showMessageDialog(null,"Menor Distancia entre P1("+pA.getX()+","
                    +pA.getY()+") y P2("+pB.getX()+","+pB.getY()+")  -  Dist(P1,P2)="+String.format("%.3f",dis));
        }
    }
    /*Metodo que ayuda ayuda a separar un par de coordenadas, ya que cuando se piden los datos se da una cadena separada por comas*/
    private static int[] getCoordenadas(String c){
        int coordenada[] = {0,0};
        String temp = "";
        for (int i=0 ; i<c.length() ; i++){
            if (i == c.length()-1){
                temp = temp + c.charAt(i);
                coordenada[1] = Integer.parseInt(temp);
            }
            if (c.charAt(i)==44){
                coordenada[0] = Integer.parseInt(temp);
                temp = "";
            }else
                temp = temp + c.charAt(i);
        }
        return coordenada;
    }
}