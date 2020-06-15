package Graficacion.segundoParcial.RetosProgramacion;

/*
* Mina
*
* Un minero afortunado se encuentra el mapa de una mina encantada la cual tiene N niveles, en cada nivel hay M grutas y en cada gruta
* hay una bolsa que puede contener monedas de oro. Viendo el mapa, el minero se percata que la mina también tiene M entradas y que
* al salir de cada gruta, solo puede ir a la gruta que está en el siguiente nivel a la derecha, a la izquierda o enfrente. El mapa
* tiene escrita una advertencia: "Cuando un ser mortal avance al siguiente nivel, aquél en el que estaba será destruido..." y como
* buen mortal, le hará caso a esta advertencia. El minero decide entrar a la mina para salir con tantas monedas como sea posible.
* */

import javax.swing.*;

public class Programa3
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null,"Mina\n\n" +
                "Un minero afortunado se encuentra el mapa de una mina encantada la cual tiene N niveles, en cada nivel hay M grutas y en cada gruta\n" +
                "hay una bolsa que puede contener monedas de oro. Viendo el mapa, el minero se percata que la mina también tiene M entradas y que\n" +
                "al salir de cada gruta, solo puede ir a la gruta que está en el siguiente nivel a la derecha, a la izquierda o enfrente. El mapa\n" +
                "tiene escrita una advertencia: \"Cuando un ser mortal avance al siguiente nivel, aquél en el que estaba será destruido...\" y como\n" +
                "buen mortal, le hará caso a esta advertencia. El minero decide entrar a la mina para salir con tantas monedas como sea posible.");

        int N = Integer.parseInt(JOptionPane.showInputDialog("Teclee N niveles"));
        int M = Integer.parseInt(JOptionPane.showInputDialog("Teclee M grutas"));
        int maxRS = 0;
        int mina[][] = new int[N][M];

        for (int i=0; i<N ; i++) {
            for (int j=0; j<M ; j++) {
                mina[i][j] = Integer.parseInt(JOptionPane.showInputDialog("mina["+i+"]["+j+"]"));
            }
        }

        for (int i=N-2 ; i>=0 ; i--){
            for (int j=1; j<M ; j++) {
                mina[i][j] = mina[i][j] + maximo(mina[i+1][j-1],mina[i+1][j],mina[i+1][j+1]);
            }
        }

        for (int i=1 ; i<= M; i++)
        {
            if (mina[0][i] > maxRS)
                maxRS = mina[0][i];
        }

        System.out.println(maxRS);
    }

    private static int maximo(int a,int b,int c){
        int temp = a;
        if (b>temp)
            temp = b;
        if (c>temp)
            temp = c;
        return temp;
    }

}

/*
*     public class Prob_Mina_OMI96Unit
    {
        public static int[, ] mina = new int[101 + 1, 101 + 1];
        public static int N = 0;
        public static int M = 0;
        public static int MaxRS = 0;
        public static int i = 0;
        public static int j = 0;
        public static System.IO.Stream f = null;
        public static void ReadInput()
        {
            N = 6;
            M = 9;
            mina[1][1] = 1;
            mina[1][2] = 8;
            mina[1][3] = 2;
            mina[1][4] = 5;
            mina[1][5] = 3;
            mina[1][6] = 0;
            mina[1][7] = 6;
            mina[1][8] = 3;
            mina[1][9] = 4;
            mina[2][1] = 0;
            mina[2][2] = 2;
            mina[2][3] = 4;
            mina[2][4] = 0;
            mina[2][5] = 8;
            mina[2][6] = 4;
            mina[2][7] = 4;
            mina[2][8] = 6;
            mina[2][9] = 0;
            mina[3][1] = 8;
            mina[3][2] = 2;
            mina[3][3] = 2;
            mina[3][4] = 6;
            mina[3][5] = 0;
            mina[3][6] = 1;
            mina[3][7] = 4;
            mina[3][8] = 5;
            mina[3][9] = 6;
            mina[4][1] = 6;
            mina[4][2] = 1;
            mina[4][3] = 7;
            mina[4][4] = 0;
            mina[4][5] = 1;
            mina[4][6] = 2;
            mina[4][7] = 5;
            mina[4][8] = 1;
            mina[4][9] = 2;
            mina[5][1] = 9;
            mina[5][2] = 7;
            mina[5][3] = 0;
            mina[5][4] = 2;
            mina[5][5] = 3;
            mina[5][6] = 6;
            mina[5][7] = 7;
            mina[5][8] = 3;
            mina[5][9] = 8;
            mina[6][1] = 2;
            mina[6][2] = 8;
            mina[6][3] = 5;
            mina[6][4] = 7;
            mina[6][5] = 4;
            mina[6][6] = 7;
            mina[6][7] = 1;
            mina[6][8] = 5;
            mina[6][9] = 0;
        }

        public static int Max(int a, int b, int c)
        {
            int result;
            int t;
            t = a;
            if (b > t)
            {
                t = b;
            }
            if (c > t)
            {
                t = c;
            }
            result = t;
            return result;
        }

        public static void ComputeAnswer()
        {
            // Calcula el maximo beneficio para cada gruta, despues de
            // regresar de cualquiera de las 3 grutas anteriores
            for (i = N - 1; i >= 1; i-- )
            {
                for (j = 1; j <= M; j ++ )
                {
                    mina[i, j] = mina[i, j] + Max(mina[i + 1, j - 1], mina[i + 1, j], mina[i + 1, j + 1]);
                }
            }
            MaxRS = 0;
            // Calcula la suma maxima por alguna de las rutas posibles
            for (i = 1; i <= M; i ++ )
            {
                if (mina[1, i] > MaxRS)
                {
                    MaxRS = mina[1, i];
                }
            }
            //@ Unsupported function or procedure: 'Assign'
            Assign(f, "mina.out");
            StreamWriter _W_0 = f.CreateText();
            _W_0.WriteLine(MaxRS);
            // Localiza las grutas de entrada que dan un maximo
            for (i = 1; i <= M; i ++ )
            {
                if (mina[1, i] == MaxRS)
                {
                    _W_0.Write(i);
                    _W_0.Write(' ');
                }
            }
            _W_0.Close();
        }

        [STAThread]
        public static void Main(string[] args)
        {
            ReadInput();
            ComputeAnswer();
            Application.Run();
        }

    } // end Prob_Mina_OMI96

}


* */