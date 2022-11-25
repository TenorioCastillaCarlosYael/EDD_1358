//Tenorio Castilla Carlos Yael
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 */
public class Tablero {

    //Método Main y método constructor solo están de adorno.
    public static void main(String[] args) {
    }

    public Tablero() {
    }

    public static void llenarTablero(Arreglos_2D_ADT Matriz, char Elemento) {
        for (int Fik = 0; Fik < Matriz.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Matriz.get_Columnas(); Cok++) {
                Matriz.set_Item(Fik, Cok, Elemento);
            }
        }
    }

    public static void imprimirTablero(Arreglos_2D_ADT Matriz) {
        System.out.println("-------------------");
        for (int Fik = 0; Fik < Matriz.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Matriz.get_Columnas(); Cok++) {
                System.out.print(Matriz.get_Item(Fik, Cok) + " ");
            }
            System.out.print("\n");
        }
        System.out.println("-------------------");
    }

    public static boolean checarLimites(int filas, int columnas, int px, int py) {
        return (px >= filas && px < filas && py >= columnas && py < columnas);
    }

    public static int checkLimites(int Filas, int Columnas, int px, int py) {
        /*
        Primero checará si Célula está dentro de la matriz (Lo cual es cierto).
        Luego verá en qué posición está Célula para saber si a la posición de
        la célula se le puede restar -1 en la dirección x y y.
        Luego retornará un número para cada caso.
         */
        if (px >= 0 && px < Filas && py >= 0 && py < Columnas) {
//----------------------------------
            if (px - 1 != - 1 && py - 1 != - 1 && px + 1 < Filas && py + 1 < Columnas) {
                return 0;
            }

            if (px - 1 != - 1 && py - 1 != - 1 && px + 1 > Filas && py + 1 <= Columnas) {
                return 1;
            }

            if (px - 1 != - 1 && py - 1 != - 1 && px + 1 <= Filas && py + 1 > Columnas) {
                return 2;
            }

            if (px - 1 != - 1 && py - 1 != - 1 && px + 1 > Filas && py + 1 > Columnas) {
                return 3;
            }

            if (px - 1 == - 1 && py - 1 != - 1 && px + 1 <= Filas && py + 1 <= Columnas) {
                return 4;
            }

            if (px - 1 != - 1 && py - 1 == - 1 && px + 1 <= Filas && py + 1 <= Columnas) {
                return 5;
            }

            if (px - 1 == - 1 && py - 1 == - 1 && px + 1 <= Filas && py + 1 <= Columnas) {
                return 6;
            }
//----------------------------------
        }
        return 7; //retorna 5 si no entra en nada.
    }

    public static void igualarTablero(Arreglos_2D_ADT Matriz, Arreglos_2D_ADT Auxiliar) {
        for (int Fik = 0; Fik < Auxiliar.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Auxiliar.get_Columnas(); Cok++) {
                Matriz.set_Item(Fik, Cok, Auxiliar.get_Item(Fik, Cok));
            }
        }
    }

    public static void limpiar(Arreglos_2D_ADT Auxiliar, char Elemento) {
        for (int Fik = 0; Fik < Auxiliar.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Auxiliar.get_Columnas(); Cok++) {
                    Auxiliar.set_Item(Fik, Cok, Elemento);
            }
        }
    }
}
