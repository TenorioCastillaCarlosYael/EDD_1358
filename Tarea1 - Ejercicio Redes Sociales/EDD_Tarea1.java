//Tenorio Castilla Carlos Yael
/*Fecha de entrega: 24 de agosto de 2022
Propósito: 
Hacer un programa que lea el archivo "presenciaredes.csv".
Que muestre en pantalla la diferencia de seguidores en Twitter entre el mes de 
    enero y junio.
Que permita calcular la diferencia de visualizaciones de Youtube entre los 
    meses seleccionados por teclado (enero a junio).
Que calcule el promedio de crecimiento de Twitter y Facebook entre los meses de
    enero a junio.
 */
package tareaRedes;

/**
 * @author Tenorio Castilla Carlos Yael (Torrente)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EDD_Tarea1 extends JFrame implements ActionListener {

    private JLabel label1, label2, label3;
    private JTextField texto1;
    private JButton boton1, boton2;
    public static String Nombre = "";

    public EDD_Tarea1() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenida/o");
        getContentPane().setBackground(new Color(48, 48, 48));

        ImageIcon URB = new ImageIcon("C:\\Users\\yael_\\OneDrive\\"
                + "Documentos\\NetBeansProjects\\"
                + "Tarea1_Ejercicio_Redes_Sociales\\src\\main\\java\\"
                + "tareaRedes\\images\\URBENIAC.png");
        label1 = new JLabel(URB);
        label1.setBounds(4, 4, 276, 33);//Derecha, Abajo, Ancho, Alto
        add(label1);

        label2 = new JLabel("Urbenia");
        label2.setBounds(70, 34, 150, 50);
        label2.setFont(new Font("OCR A Extended", 1, 31));
        label2.setForeground(new Color(255, 255, 255));
        add(label2);

        label3 = new JLabel("Usuario:");
        label3.setBounds(30, 181, 120, 22);
        label3.setFont(new Font("OCR A Extended", 0, 16));
        label3.setForeground(new Color(255, 255, 255));
        add(label3);

        texto1 = new JTextField("");
        texto1.setBounds(155, 181, 120, 20);
        texto1.setFont(new Font("OCR A Extended", 0, 16));
        add(texto1);

        boton1 = new JButton("Entrar");
        boton1.setBounds(10, 220, 120, 20);
        boton1.setFont(new Font("OCR A Extended", 0, 16));
        boton1.setBackground(new Color(0, 255, 0));
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Salir");
        boton2.setBounds(155, 220, 120, 20);
        boton2.setFont(new Font("OCR A Extended", 0, 16));
        boton2.setForeground(new Color(255, 255, 255));
        boton2.setBackground(new Color(255, 0, 0));
        add(boton2);
        boton2.addActionListener(this);

    }

    public static void main(String[] args) {
        EDD_Tarea1 Inicio = new EDD_Tarea1();
        Inicio.setBounds(0, 0, 300, 300);
        Inicio.setVisible(true);
        Inicio.setLocationRelativeTo(null);
        Inicio.setResizable(false);
        Inicio.setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent d) {
        if (d.getSource() == boton1) {
            Nombre = texto1.getText().trim();
            if (Nombre.equals("")) {
                JOptionPane.showMessageDialog(null, "No hay usuario. Ingresa tu usuario.");
            } else {
                EDD_Tarea1_p2 inicio1 = new EDD_Tarea1_p2();
                inicio1.setBounds(0, 0, 1000, 600);
                inicio1.setVisible(true);
                inicio1.setLocationRelativeTo(null);
                inicio1.setResizable(false);
                this.setVisible(false);
            }
        }
        if (d.getSource() == boton2) {
            System.exit(0);
        }
    }

}
