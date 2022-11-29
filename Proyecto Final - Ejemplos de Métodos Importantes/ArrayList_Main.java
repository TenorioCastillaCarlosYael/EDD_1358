//Tenorio Castilla Carlos Yael
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 */

import java.util.ArrayList;

public class ArrayList_Main {
    public static void main(String[] args) {
        ArrayList Arreglo = new ArrayList();
        Arreglo.add(27); //Agrega un elemento al final.
        Arreglo.add(14);
        Arreglo.add(00);
        Arreglo.add(57);
        Arreglo.get(3); //Devuelve el elemento en la posición i.
        System.out.println("¿Contiene 00? " + Arreglo.contains(00));
        Arreglo.iterator();
    }
}
