package Graficacion.PrimerParcial.RetosProgramacion;

import java.util.Scanner;

public class MatrizEntradasDiagonal
{
    public static void main(String[] args){
        //LEER ENTRADA
        /*Leer tamaño de la matriz donde m(filas) y n(columnas)*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("teclea el tamaño de la matriz m x n\nm(filas) = ");
        int m = scanner.nextInt();
        System.out.print("n(columnas) = ");
        int n = scanner.nextInt();
        /*Variable temporal mPosTemp para recorrer las filas
        * Variable temporal nPosTemp para recorrer las Columnas
        * Variable mPos para recorrer las filas comienza en fila 1
        * Variable nPos para recorrer las columnas comienza en 0
        * Variable numDiagonales que obtiene la cantidad de diagonales que va a tener la matriz
        * Variable matriz iniciandola con el número de filas (m) y columnas (n)*/
        int mPosTemp=0, nPosTemp=0, mPos=1, nPos=0, numDiagonales=m+n-1;
        int matriz[][] = new int[m][n];
        /*Un ciclo que se repite la cantidad de numDIagonales necesarias para llenar la matriz*/
        for (int i=0; i<numDiagonales ; i++){
            /*COndicion que indica que aun no ha llegado al limite de las columnas, por lo
            * tanto va a acomodar en diagonal empezando por un numero de columna y la fila 0
            * retrocediendo la columna y aumentando la fila evitando siempre llegar al limite
            * ya sea de la columna o de la fila*/
            if (nPos<n){
                nPosTemp=nPos;
                mPosTemp=0;
                nPos=nPos+1;
                while(nPosTemp>=0 && mPosTemp<m){
                    System.out.print("Matriz["+mPosTemp+"]["+nPosTemp+"] = ");
                    matriz[mPosTemp][nPosTemp] = scanner.nextInt();
                    nPosTemp = nPosTemp - 1;
                    mPosTemp = mPosTemp + 1;
                }
            /*Cuando ya se acabaron las columnas y ya no se puede empezar por un numero de columna
            * se empieza ahora por la segunda fila, es decir fila 1 y columna ultima, con la condicion
            * de que ahora las filas son las que se van a contar y no las columnsa*/
            }else if (mPos < m){
                nPosTemp=n-1;
                mPosTemp=mPos;
                mPos=mPos+1;
                while(nPosTemp>=0 && mPosTemp<m){
                    System.out.print("Matriz["+mPosTemp+"]["+nPosTemp+"] = ");
                    matriz[mPosTemp][nPosTemp] = scanner.nextInt();
                    nPosTemp = nPosTemp - 1;
                    mPosTemp = mPosTemp + 1;
                }

            }
        }
        /*Al final se imprime la matriz en consola de java para verificar que se realizo correctamente*/
        for (int i=0 ; i<m ; i++){
            for (int j=0 ; j<n ; j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
    }
}