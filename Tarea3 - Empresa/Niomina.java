package com.urbenia.arreglos_adt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author yael_
 */
public class Niomina {

    public static void main(String[] args) throws FileNotFoundException {
        File Arch = new File("C:/Users/yael_/OneDrive/Escritorio/julio.dat"); //Sirve con "julio.dat" pero no con "junio.dat" POR??????
        Niomina Prueba = new Niomina(Arch);
        Prueba.Lista_Sueldo();
        System.out.println("--------------------|-|-|-|-|--------------------");
        Prueba.Mayor_Ant();
        Prueba.Menor_Ant();
    }

    int rozmiar = 0;
    String LineasL = "";
    ArrayList<ArrayList<String>> OutterArray = new ArrayList();
    Arreglos_ADT<Empleado> Nomina;
    String[] Lineas;
    String[] TamLis;
    Empleado Emp;
    Empleado Imp;
    Empleado Maximus;
    Empleado MediumMax;
    Empleado Minumus;
    Empleado MediumMin;

    public Niomina(File Arch) { //Constructor
        try {
            Path Ruta = Arch.toPath();
            BufferedReader lector = Files.newBufferedReader(Ruta);
            String Leido;

            while ((Leido = lector.readLine()) != null) {
                Lineas = Leido.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                TamLis = Leido.split("\n");
                rozmiar += TamLis.length;
                ArrayList<String> InnerArray = new ArrayList();
                for (String datos : Lineas) {
                    InnerArray.add(datos);
                }
                OutterArray.add(InnerArray);
            }

            //Esta parte es para asignar los valores al ADT Empleado
            Nomina = new Arreglos_ADT(rozmiar - 1);
            int Columnas = 0;
            for (int Filas = 1; Filas < OutterArray.size(); Filas++) {
                Emp = new Empleado(Integer.parseInt(OutterArray.get(Filas).get(0)), OutterArray.get(Filas).get(1), OutterArray.get(Filas).get(2), OutterArray.get(Filas).get(3), Integer.parseInt(OutterArray.get(Filas).get(4)), Integer.parseInt(OutterArray.get(Filas).get(5)), Integer.parseInt(OutterArray.get(Filas).get(6)));
                Nomina.setItem(Columnas, Emp);
                Columnas++;
            }

        } catch (IOException ex) {
        }

    }

    public void Lista_Sueldo() {
        for (int rozmita = 0; rozmita < Nomina.getLenght(); rozmita++) {
            Imp = Nomina.getItem(rozmita);
            System.out.println("Id: " + Imp.get_NumTrabajador() + "; Sueldo: " + Imp.CalcularSueldo());
        }
    }

    public void Mayor_Ant() {
        int Max = 2023;
        String Who = "";
        String SeWho = "";
        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            Maximus = Nomina.getItem(ind);
            if (Maximus.get_AñoIngreso() < Max) {
                Max = Maximus.get_AñoIngreso();
                Who = Maximus.get_Nombres();
            }
        }
        System.out.println("Persona con mayor antiguedad: " + Who + ", desde: " + Max);

        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            MediumMax = Nomina.getItem(ind);
            if (MediumMax.get_AñoIngreso() < Max && MediumMax.get_Nombres().equals(Who)) {
                //Si lo encuentra, no hace nada.
            } else {
                Max = MediumMax.get_AñoIngreso();
                SeWho = MediumMax.get_Nombres();
            }
        }
        System.out.println("La segunda persona con mayor antiguedad: " + SeWho + ", desde: " + Max);
    }

    public void Menor_Ant() {
        int Max2 = 2016;
        String Who2 = "";
        String SeWho2 = "";
        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            Minumus = Nomina.getItem(ind);
            if (Minumus.get_AñoIngreso() > Max2) {
                Max2 = Minumus.get_AñoIngreso();
                Who2 = Minumus.get_Nombres();
            }
        }
        System.out.println("Persona con menor antiguedad: " + Who2 + ", desde: " + Max2);

        int Max20 = Max2;
        for (int ind = 0; ind < Nomina.getLenght(); ind++) {
            MediumMin = Nomina.getItem(ind);
            if (MediumMin.get_AñoIngreso() == Max2) {
                if (MediumMin.get_Nombres().equals(Who2)) {
                    //Si lo encuentra, no hace nada.
                } else {
                    Max2 = MediumMin.get_AñoIngreso();
                    SeWho2 = MediumMin.get_Nombres();
                }
            }
        }
        System.out.println("La segunda persona con menor antiguedad: " + SeWho2 + ", desde: " + Max2);
    }

}
