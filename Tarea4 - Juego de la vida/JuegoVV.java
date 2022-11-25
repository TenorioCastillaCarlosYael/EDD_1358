//Tenorio Castilla Carlos Yael
/*Programar el juego desarrollado por John Horton Conway, nombrado como
"El juego de la vida".

Diseñar el algoritmo que determine si una celda está viva o muerta mediante las
siguientes reglas.

Reglas:

1.- Si una célula está viva y tiene dos o tres vecinos vivos, la célula 
permanece viva en la siguiente generación. 
Los vecinos son las ocho celdas que rodean inmediatamente una celda: vertical, 
horizontal y diagonalmente.

2.- Si una célula viva que no tiene vecinos vivos o un solo vecino vivo muere 
por aislamiento en la próxima generación.

3.- Una célula viva que tiene cuatro o más vecinos vivos muere por 
sobrepoblación en la próxima generación.

4.- Una celda muerta con exactamente tres vecinos vivos da como resultado un 
nacimiento y cobra vida en la siguiente generación. Todas las demás células 
muertas permanecen muertas en la próxima generación.

El programa completo deberá simular por lo menos 10 generaciones.

La entrega será mediante link del repositorio Github que contenga el proyecto.
 */
package com.urbenia.arreglos_adt;

import java.util.ArrayList;

/**
 *
 * @author yael_
 */
public class JuegoVV {

    public static void main(String[] args) {
        JuegoVV Game = new JuegoVV(10, 10);
        //JuegoV.aplicarReglas(Matriz, Coordenadas);

    }

    public JuegoVV(int Filas, int Columnas) { //Constructor
        Arreglos_2D_ADT Juego = new Arreglos_2D_ADT(Filas, Columnas);

        for (int Fik = 0; Fik < Juego.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Juego.get_Columnas(); Cok++) {
                Juego.set_Item(Fik, Cok, '.');
            }
        }

        Juego.set_Item(5, 4, 'x');
        Juego.set_Item(5, 5, 'x');
        Juego.set_Item(5, 6, 'x');
        Juego.set_Item(6, 5, 'x');

        //Lo muestra
        System.out.println("Matriz Original:");
        for (int Fik = 0; Fik < Juego.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Juego.get_Columnas(); Cok++) {
                System.out.print(Juego.get_Item(Fik, Cok) + " ");
            }
            System.out.print("\n");
        }

        int Vueltas = 4;
        for (int Iter = 1; Iter < Vueltas; Iter++) {
            JuegoVV.vecinosVivos(Juego);
            System.out.println("Iteración no. " + Iter);
        }
        //JuegoV.vecinosVivos(Juego);

    }

    public static boolean checarLim(int filas, int columnas, int px, int py) {
        return (px >= filas && px < filas && py >= columnas && py < columnas);
    }

    public static void vecinosVivos(Arreglos_2D_ADT Matriz) {
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
        JuegoVV.aplicarReglas(Matriz, Coordenadas);
    }

    public static void aplicarReglas(Arreglos_2D_ADT Matriz, ArrayList Coordenadas) {
        char C;
        int a = 2;
        int ppx = 0;
        int ppy = 0;
        int px = (int) Coordenadas.get(Coordenadas.size() - a);
        int pxx = px;
        int py = (int) Coordenadas.get(Coordenadas.size() - a + 1);
        int pyy = py;
        int cuantasx = 0;
        int cuantosp = 0;
        Arreglos_2D_ADT AUX = new Arreglos_2D_ADT(Matriz.get_Filas(), Matriz.get_Columnas());

        //Esta parte crea una copia.
        for (int Fik = 0; Fik < Matriz.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Matriz.get_Columnas(); Cok++) {
                AUX.set_Item(Fik, Cok, Matriz.get_Item(Fik, Cok));
            }
        }
        //Termina la parte de la copia.

        System.out.println(Coordenadas);
        for (int PF = px - 1; PF <= px + 1; PF++) {
            for (int SF = py - 1; SF <= py + 1; SF++) {
                C = (char) Matriz.get_Item(PF, SF);
                //System.out.print(Matriz.get_Item(PF, SF));
                if (C == 'x') {
                    if (PF == pxx && SF == pyy) {

                    } else {
                        cuantasx++;
                    }
                } else {
                    if (PF == ppx && SF == ppy) {
                        cuantosp++;
                    }
                }
            }
            //System.out.println("");
        }
        a = a + 2;

        if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
            AUX.set_Item(pxx, pyy, 'x');
        } else if (cuantasx < 2) { //Regla 2
            AUX.set_Item(pxx, pyy, '.');
        } else if (cuantasx >= 4) { //Regla 3
            AUX.set_Item(pxx, pyy, '.');
        }
        if (cuantosp == 3) { //Regla 4
            AUX.set_Item(ppx, pyy, 'x');
        }
        System.out.println("Las x encontradas son: " + cuantasx);
        JuegoVV.igualarMatriz(Matriz, AUX);
    }

    public static void igualarMatriz(Arreglos_2D_ADT Matriz, Arreglos_2D_ADT AUX) {
        for (int Fik = 0; Fik < AUX.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < AUX.get_Columnas(); Cok++) {
                Matriz.set_Item(Fik, Cok, AUX.get_Item(Fik, Cok));
            }
        }
        JuegoVV.imprimirTab(Matriz);
    }

    public static void imprimirTab(Arreglos_2D_ADT Matriz) {
        System.out.println("-------------------");
        for (int Fik = 0; Fik < Matriz.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Matriz.get_Columnas(); Cok++) {
                System.out.print(Matriz.get_Item(Fik, Cok) + " ");
            }
            System.out.print("\n");
        }
    }
}
