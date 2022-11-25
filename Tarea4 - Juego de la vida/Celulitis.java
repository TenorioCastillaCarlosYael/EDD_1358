//Tenorio Castilla Carlos Yael
package com.urbenia.arreglos_adt;

import java.util.ArrayList;

/**
 *
 * @author yael_
 */
public class Celulitis {
    
    //Método Main y método constructor solo están de adorno.
    public static void main(String[] args) {

    }

    public static void colocarCelula(Arreglos_2D_ADT Matriz, int poX, int poY, char Celula) {
        Matriz.set_Item(poX, poY, Celula);
    }

    public static boolean estado(char C) {
        return C == 'x';
    }

    public static ArrayList vecinosVivos(Arreglos_2D_ADT Matriz) {
        ArrayList Coordenadas = new ArrayList(2);
        char C;
        int px = 0;
        int py = 0;
        int a = 0;
        for (int Fil = 0; Fil < Matriz.get_Filas(); Fil++) {
            for (int Col = 0; Col < Matriz.get_Columnas(); Col++) {
                C = (char) Matriz.get_Item(Fil, Col);
                if (C == 'x') {
                    px = Fil;
                    py = Col;
                    Coordenadas.add(a, px);
                    Coordenadas.add(a + 1, py);
                }
            }
        }
        a++;
        return Coordenadas;
    }

}
