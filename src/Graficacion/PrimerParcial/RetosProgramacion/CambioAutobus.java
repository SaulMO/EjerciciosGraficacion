package Graficacion.PrimerParcial.RetosProgramacion;

import javax.swing.JOptionPane;

public class CambioAutobus
{
    public static void main(String[] args) {
        //Creación de variables c(cambio),m(no. de Monedas) y arreglo monedas
        int c = Integer.parseInt(JOptionPane.showInputDialog("Cambio"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("No de monedas"));
        int monedas[] = new int[m];
        //Pedir el valor de las monedas
        for (int i=0 ; i<m ; i++)
            monedas[i] = Integer.parseInt(JOptionPane.showInputDialog("Moneda "+(i+1)));
        //Variables iniciadas numero de monedas,
        int i = m-1, nM;
        if (c>0){//Decision si debe dar cambio
            /*Ciclo que va dividiendo el cambio con la moneda con el valor mas grande
            * despues de ello resta la cantidad de dinero que se le va a restar al
            * cambio de acuerdo a la cantidad de monedas usadas del valor.
            * Despues resta la variable i para pasar a la siguiente moneda con valor mas pequeño.
            * El ciclo termina cuando el contador i no apunte a una moneda.*/
            do{
                nM = c / monedas[i];
                JOptionPane.showMessageDialog(null,nM+"monedas de "+monedas[i],"Cambio",1);
                c = c - (nM*monedas[i]);
                i--;
            }while(i>0);
        }
        /*decision donde la condicion propone que cuando el cambio sea 0 significa que se dio
        * el cambio correcto, de no ser asi va a a mandar un error debido a que no se pudo dar el cambio correcto*/
        if (c==0)
            System.out.println("Cambio Correcto");
        else
            System.out.println("Error al dar cambio");
    }
}