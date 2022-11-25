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
public class JuegoV {

    public static void main(String[] args) {
        Arreglos_2D_ADT Tablerero = new Arreglos_2D_ADT(11, 11);
        Arreglos_2D_ADT Auxiliar = new Arreglos_2D_ADT(11, 11);
        Tablero.llenarTablero(Tablerero, '.');
        Tablero.llenarTablero(Auxiliar, '.');
        
        Celulitis.colocarCelula(Tablerero, 5, 4, 'x');
        Celulitis.colocarCelula(Tablerero, 5, 6, 'x');
        
        Celulitis.colocarCelula(Tablerero, 7, 3, 'x');
        Celulitis.colocarCelula(Tablerero, 8, 4, 'x');
        Celulitis.colocarCelula(Tablerero, 8, 5, 'x');
        Celulitis.colocarCelula(Tablerero, 8, 6, 'x');
        Celulitis.colocarCelula(Tablerero, 7, 7, 'x');

        Tablero.imprimirTablero(Tablerero);

        JuegoV Juego = new JuegoV();
        //Se crea para usar el método "aplicarReglas"

        /*
        El modelo para hacer funcionar el juego sería:
        - Obtener las coordenadas.
        - Aplicar las reglas. (Hacer un iterador dependiendo del tamaño de la lista - 1 / 2).
        - Igualar el tablero.
        - Imprimir tablero.
        Todo dentro de un iterador.
         */
        int Vueltas = 12;
        for (int Iter = 0; Iter < Vueltas; Iter++) {
            int aCoord = 2;//Será la variable que itere sobre la lista de coordenadas.
            ArrayList Coordenadas = Celulitis.vecinosVivos(Tablerero);

            for (int SuperIter = 0; SuperIter < (Coordenadas.size() / 2); SuperIter++) {
                Juego.aplicarReglasVivos(Tablerero, Coordenadas, Auxiliar, aCoord);
                if (aCoord < Coordenadas.size()) {
                    aCoord += 2;
                }

            }
            Juego.aplicarReglasMuertos(Tablerero, Auxiliar);
            Tablero.igualarTablero(Tablerero, Auxiliar);
            Tablero.llenarTablero(Auxiliar, '.');
            Tablero.imprimirTablero(Tablerero);
        }

    }

    //Método constructor solo está de adorno.
    public JuegoV() { //Constructor
    }

    public void aplicarReglasVivos(Arreglos_2D_ADT Matriz, ArrayList Coordenadas, Arreglos_2D_ADT Auxiliar, int aCoord) {
        char C; //C de Célula.
        //Obtiene el último elemento - 2 de la lista, que viene siendo la posicíon x de una célula.
        int px = (int) Coordenadas.get(Coordenadas.size() - aCoord);
        //Guarda la posición de la célula en x (no confundir px, que es la posición de la célula dentro de la lista.
        int PosiciónEstáticaX = px;
        //Obtiene el último elemento - 1 de la lista, que viene siendo la posicíon y de una célula.
        int py = (int) Coordenadas.get(Coordenadas.size() - aCoord + 1);
        //Guarda la posición de la célula en y (no confundir py, que es la posición de la célula dentro de la lista.
        int PosiciónEstáticaY = py;
        //Contador que se reinicia cada iteración para saber qué regla aplicar.
        //int cuantasx = 0;

        if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), px, py) == 0) {
            int cuantasx = 0;
            for (int IterFilas = px - 1; IterFilas <= px + 1; IterFilas++) {
                for (int IterColu = py - 1; IterColu <= py + 1; IterColu++) {
                    C = (char) Matriz.get_Item(IterFilas, IterColu);
                    if (Celulitis.estado(C)) {
                        if (IterFilas == PosiciónEstáticaX && IterColu == PosiciónEstáticaY) {
                        } else {
                            cuantasx++;
                        }
                    }
                }
            }
            //System.out.println("Cuantas x: " + cuantasx);
            if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, 'x');
            } else if (cuantasx < 2) { //Regla 2
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            } else if (cuantasx >= 4) { //Regla 3
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            }
        }
        if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), px, py) == 1) {
            int cuantasx = 0;
            for (int IterFilas = px - 1; IterFilas <= px + 1; IterFilas++) {
                for (int IterColu = py - 1; IterColu <= py; IterColu++) {
                    C = (char) Matriz.get_Item(IterFilas, IterColu);
                    if (Celulitis.estado(C)) {
                        if (IterFilas == PosiciónEstáticaX && IterColu == PosiciónEstáticaY) {
                        } else {
                            cuantasx++;
                        }
                    }
                }
            }
            System.out.println("Cuantas x: " + cuantasx);
            if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, 'x');
            } else if (cuantasx < 2) { //Regla 2
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            } else if (cuantasx > 3) { //Regla 3
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            }
        }
        if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), px, py) == 2) {
            int cuantasx = 0;
            for (int IterFilas = px - 1; IterFilas <= px; IterFilas++) {
                for (int IterColu = py - 1; IterColu <= py + 1; IterColu++) {
                    C = (char) Matriz.get_Item(IterFilas, IterColu);
                    if (Celulitis.estado(C)) {
                        if (IterFilas == PosiciónEstáticaX && IterColu == PosiciónEstáticaY) {
                        } else {
                            cuantasx++;
                        }
                    }
                }
            }
            System.out.println("Cuantas x: " + cuantasx);
            if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, 'x');
            } else if (cuantasx < 2) { //Regla 2
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            } else if (cuantasx > 3) { //Regla 3
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            }
        }
        if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), px, py) == 3) {
            int cuantasx = 0;
            for (int IterFilas = px - 1; IterFilas <= px + 1; IterFilas++) {
                for (int IterColu = py - 1; IterColu <= py + 1; IterColu++) {
                    C = (char) Matriz.get_Item(IterFilas, IterColu);
                    if (Celulitis.estado(C)) {
                        if (IterFilas == PosiciónEstáticaX && IterColu == PosiciónEstáticaY) {
                        } else {
                            cuantasx++;
                        }
                    }
                }
            }
            System.out.println("Cuantas x: " + cuantasx);
            if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, 'x');
            } else if (cuantasx < 2) { //Regla 2
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            } else if (cuantasx > 3) { //Regla 3
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            }
        }
        if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), px, py) == 4) {
            int cuantasx = 0;
            for (int IterFilas = px - 1; IterFilas <= px + 1; IterFilas++) {
                for (int IterColu = py - 1; IterColu <= py + 1; IterColu++) {
                    C = (char) Matriz.get_Item(IterFilas, IterColu);
                    if (Celulitis.estado(C)) {
                        if (IterFilas == PosiciónEstáticaX && IterColu == PosiciónEstáticaY) {
                        } else {
                            cuantasx++;
                        }
                    }
                }
            }
            System.out.println("Cuantas x: " + cuantasx);
            if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, 'x');
            } else if (cuantasx < 2) { //Regla 2
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            } else if (cuantasx > 3) { //Regla 3
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            }
        }
        if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), px, py) == 5) {
            int cuantasx = 0;
            for (int IterFilas = px - 1; IterFilas <= px + 1; IterFilas++) {
                for (int IterColu = py - 1; IterColu <= py + 1; IterColu++) {
                    C = (char) Matriz.get_Item(IterFilas, IterColu);
                    if (Celulitis.estado(C)) {
                        if (IterFilas == PosiciónEstáticaX && IterColu == PosiciónEstáticaY) {
                        } else {
                            cuantasx++;
                        }
                    }
                }
            }
            System.out.println("Cuantas x: " + cuantasx);
            if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, 'x');
            } else if (cuantasx < 2) { //Regla 2
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            } else if (cuantasx > 3) { //Regla 3
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            }
        }
        if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), px, py) == 6) {
            int cuantasx = 0;
            for (int IterFilas = px - 1; IterFilas <= px + 1; IterFilas++) {
                for (int IterColu = py - 1; IterColu <= py + 1; IterColu++) {
                    C = (char) Matriz.get_Item(IterFilas, IterColu);
                    if (Celulitis.estado(C)) {
                        if (IterFilas == PosiciónEstáticaX && IterColu == PosiciónEstáticaY) {
                        } else {
                            cuantasx++;
                        }
                    }
                }
            }
            System.out.println("Cuantas x: " + cuantasx);
            if (cuantasx == 2 || cuantasx == 3) {   //Regla 1
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, 'x');
            } else if (cuantasx < 2) { //Regla 2
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            } else if (cuantasx > 3) { //Regla 3
                Auxiliar.set_Item(PosiciónEstáticaX, PosiciónEstáticaY, '.');
            }
        }
    }

    public void aplicarReglasMuertos(Arreglos_2D_ADT Matriz, Arreglos_2D_ADT Auxiliar) {
        char C; //C de Célula.
        char c; //C de celulita.
        int PosX = 0;
        int PosY = 0;
        int px = 0;
        int py = 0;

        for (int Fillaz = 0; Fillaz < Matriz.get_Filas(); Fillaz++) {
            for (int Collz = 0; Collz < Matriz.get_Columnas(); Collz++) {
                C = (char) Matriz.get_Item(Fillaz, Collz);
                if (Celulitis.estado(C) == false) {
                    PosX = Fillaz;
                    PosY = Collz;
                    if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), PosX, PosY) == 0) {
                        int cuantosp = 0;
                        for (int IterFilas = PosX - 1; IterFilas <= PosX + 1; IterFilas++) {
                            for (int IterColu = PosY - 1; IterColu <= PosY + 1; IterColu++) {
                                c = (char) Matriz.get_Item(IterFilas, IterColu);
                                if (c == 'x') {
                                    px = PosX;
                                    py = PosY;
                                    cuantosp++;
                                }
                            }
                        }
                        if (cuantosp == 3) { //Regla 4
                            Auxiliar.set_Item(px, py, 'x');
                        }
                    }
                    if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), PosX, PosY) == 1) {
                        int cuantosp = 0;
                        for (int IterFilas = PosX - 1; IterFilas < PosX; IterFilas++) {
                            for (int IterColu = PosY - 1; IterColu < PosY + 1; IterColu++) {
                                c = (char) Matriz.get_Item(IterFilas, IterColu);
                                if (c == 'x') {
                                    px = PosX;
                                    py = PosY;
                                    cuantosp++;
                                }
                            }
                        }
                        if (cuantosp == 3) { //Regla 4
                            Auxiliar.set_Item(px, py, 'x');
                        }
                    }
                    if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), PosX, PosY) == 2) {
                        int cuantosp = 0;
                        for (int IterFilas = PosX - 1; IterFilas < PosX + 1; IterFilas++) {
                            for (int IterColu = PosY - 1; IterColu < PosY; IterColu++) {
                                c = (char) Matriz.get_Item(IterFilas, IterColu);
                                if (c == 'x') {
                                    px = PosX;
                                    py = PosY;
                                    cuantosp++;
                                }
                            }
                        }
                        if (cuantosp == 3) { //Regla 4
                            Auxiliar.set_Item(px, py, 'x');
                        }
                    }
                    if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), PosX, PosY) == 3) {
                        int cuantosp = 0;
                        for (int IterFilas = PosX - 1; IterFilas < PosX; IterFilas++) {
                            for (int IterColu = PosY - 1; IterColu < PosY; IterColu++) {
                                c = (char) Matriz.get_Item(IterFilas, IterColu);
                                if (c == 'x') {
                                    px = PosX;
                                    py = PosY;
                                    cuantosp++;
                                }
                            }
                        }
                        if (cuantosp == 3) { //Regla 4
                            Auxiliar.set_Item(px, py, 'x');
                        }
                    }
                    if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), PosX, PosY) == 4) {
                        int cuantosp = 0;
                        for (int IterFilas = PosX; IterFilas < PosX + 1; IterFilas++) {
                            for (int IterColu = PosY - 1; IterColu < PosY + 1; IterColu++) {
                                c = (char) Matriz.get_Item(IterFilas, IterColu);
                                if (c == 'x') {
                                    px = PosX;
                                    py = PosY;
                                    cuantosp++;
                                }
                            }
                        }
                        if (cuantosp == 3) { //Regla 4
                            Auxiliar.set_Item(px, py, 'x');
                        }
                    }
                    if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), PosX, PosY) == 5) {
                        int cuantosp = 0;
                        for (int IterFilas = PosX - 1; IterFilas < PosX + 1; IterFilas++) {
                            for (int IterColu = PosY; IterColu < PosY + 1; IterColu++) {
                                c = (char) Matriz.get_Item(IterFilas, IterColu);
                                if (Celulitis.estado(c)) {
                                    px = PosX;
                                    py = PosY;
                                    cuantosp++;
                                }
                            }
                        }
                        if (cuantosp == 3) { //Regla 4
                            Auxiliar.set_Item(px, py, 'x');
                        }
                    }
                    if (Tablero.checkLimites(Matriz.get_Filas(), Matriz.get_Columnas(), PosX, PosY) == 6) {
                        int cuantosp = 0;
                        for (int IterFilas = PosX; IterFilas < PosX + 1; IterFilas++) {
                            for (int IterColu = PosY; IterColu < PosY + 1; IterColu++) {
                                c = (char) Matriz.get_Item(IterFilas, IterColu);
                                if (c == 'x') {
                                    px = PosX;
                                    py = PosY;
                                    cuantosp++;
                                }
                            }
                        }
                        if (cuantosp == 3) { //Regla 4
                            Auxiliar.set_Item(px, py, 'x');
                        }
                    }

                }
            }
        }

    }
}
