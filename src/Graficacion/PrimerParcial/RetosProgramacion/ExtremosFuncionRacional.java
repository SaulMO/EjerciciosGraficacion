package Graficacion.PrimerParcial.RetosProgramacion;

import java.util.Scanner;

public class ExtremosFuncionRacional
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //Creacion de variables pedidas en el reto
        double p,q,r,s,m,n;
        do{
            /*Asignar valor a los intervalos de funcion m a n
            * condicionando que m sea mayor a n*/
            System.out.print("Teclea los intervalos de la función dados por m a n\nm = ");
            m = scanner.nextDouble();
            System.out.print("n = ");
            n = scanner.nextDouble();
        } while (m>n);
        /*Asignar valor a a,b,c,d*/
        System.out.println("Teclear variables (a,b,c,d) en formula f(x)=(ax+b)/(cx+d)");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();
        System.out.print("d = ");
        double d = scanner.nextDouble();
        /*Considerar a p como variable dependiente y aplicarle la formula del reto e inicializar
        * a q como p*/
        p=((a*m)+b)/((c*m)+d);  q=p;
        double temp;
        /*Ciclo for que sirve para recorrer los intervalos de m a n y asi encontrar el valor maximo
        * guardandolo en p y el valor minimo guardandolo en q*/
        for (int i=(int)(m+1) ; i<=n ; i++){
            temp = ((a*i)+b) / ((c*i)+d);
            System.out.println(i+" "+temp);
            if (p<temp && (((c*i)+d)!=0))
                p = temp;
            if (q>temp)
                q = temp;
        }
        System.out.println("p "+p+"\tq "+q);
        /*Al final sustituimos la formula dejando la variable independiente sola tanto r para
        el valor maximo y s como variable independiente para q, para asi sustituir con los
        * valores dados de a,b,c,d y el valor minimo (q) y valor maximo (p)*/
        r = (b-(p*d))/((p*c)-a);
        s = (b-(q*d))/((q*c)-a);

        System.out.println("r = "+r+"\ts = "+s);
    }
}