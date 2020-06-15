package Graficacion.TercerParcial.Proyecto.Controlador;

import javax.swing.*;
import java.awt.*;

public class VentanaCronometro extends JFrame
{
    private JLabel label;

    public VentanaCronometro(){
        initialize();
        setSize(200,120);
        getContentPane().setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        show();
    }
    private void initialize(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("0000");
        label.setFont(new Font("Traditional Arabic",Font.PLAIN,40));
        label.setBounds(0,0,200,120);
        getContentPane().add(label);
    }
    public void change(int t){
        label.setText(t+"");
    }
}