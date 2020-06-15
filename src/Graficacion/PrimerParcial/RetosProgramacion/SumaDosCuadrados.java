package Graficacion.PrimerParcial.RetosProgramacion;

import java.util.Scanner;

public class SumaDosCuadrados
{
    public static void main(String[] args){
        /*Leer un numero y guardarlo en una variable entera n*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Teclea un número\nn = ");
        int n = scanner.nextInt();
        /*Variable formas que nos ayuda a saber el numero
        * de pares de numeros para obtener un numero,
        * La variable nA va a ser menor o igual que nB por lo tanto
        * nB se inicializa con el numero al cuadrado mayor que se puede obtener*/
        int formas=0,nA,nB=n+1;
        /*Decision si numero es 0 ó 1 existe solo una forma para obtener un par
        * de numeros al cuadrado para obtener ese numero*/
        if (n==0 || n==1){
            formas = 1;
        }else{
            /*Negación de si número es 0 ó 1 realiza un ciclo while para encontrar el
            * número mayor al cuadrado que se puede usar para obtener el número*/
            do {
                nB = nB-1;
            }while((nB*nB>n));
            /*Un ciclo for que empieza desde el numero al cuadrado maximo que se puede usar (nB) hasta cero
            * y dentro de este un ciclo anidado for que usa el valor nB para hacer el ciclo desde 0 hasta un
            * número antes que el nB, pudiendo asi agarrar dos variables de los ciclos para elevarlos
            * al cuadrado, sumarlos y compararlos para ver si es el número dado.
            * Cuando existen coincidencias con el número se aumenta el contador de formas posibles(formas)
            * y se imprime el valor de las variables de los dos ciclos que hicieron posible
            * que la suma de dos cuadrados sea igual al número*/
            for (int i=nB ; i>=0 ; i--){
                for (int j=0 ; j<nB ; j++){
                    if ((i*i)+(j*j)==n){
                        formas=formas+1;
                        System.out.println("("+i+"x"+i+")+("+j+"x"+j+") = "+n);
                    }
                }
            }
        }
        /*AL final se imprimen el número de posibles formas*/
        System.out.print("\nExisten "+formas+" Posibilidades");
    }
}