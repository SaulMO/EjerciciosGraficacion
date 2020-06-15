package Graficacion.PrimerParcial.RetosProgramacion;

import java.util.Scanner;

public class DosBasesNumericas
{
    public static void main(String[] args){
        /*Guardar expresiones pedidas en una variable A y B*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Teclear Expresiones\nA = ");
        String A = scanner.nextLine();
        System.out.print("B = ");
        String B = scanner.nextLine();
        /*variable numA entera que guarda el valor de la transformacion de la expresion A
        * variable numB entera que guarda el valor de la transformacion de la expresion B*/
        int numA,numB,exp=0;
        /*Ciclo del 1 al 20 que va a manejar los exponentes de expresionA*/
        for (int i=1; i<20 ; i++){
            numA=0;exp=0;
            /*Ciclo anidado dentro del ciclo que asigna los exponentes para sumar y obtener el número A*/
            for (int a=A.length()-1 ; a>=0 ; a--){
                if (A.charAt(a) == '1')
                    numA =(int) Math.pow(i,exp) + numA;
                exp++;
            }
            /*Ciclo anidadodentor del ciclo que asigna los exponentes para sumar y obtener el numero A
            * donde este ciclo va del 0 al 20 asignando valor de exponentes para sumar y obtener el numero B
            * para asi realizar una comparación y ver si son iguales numA y numB, encontrando asi una
            * coincidencia con determinadas bases imprimiendolas para que quede reflejado en la consola*/
            for (int j=1 ; j<20 ; j++){
                numB=0;exp=0;
                for (int b=B.length()-1 ; b>=0 ; b--){
                    if (B.charAt(b) == '1')
                        numB =(int) Math.pow(j,exp) + numB;
                    exp++;
                }
                if (numA == numB){
                    System.out.println("Se encontro coincidencia\nBase "+i+"("+numA+") = Base "+j+"("+numB+")");
                }
            }
        }
    }
}