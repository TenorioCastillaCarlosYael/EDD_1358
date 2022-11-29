//Tenorio Castilla Carlos Yael
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 */
public class Pilas_Main {

    public static void main(String[] args) {
        Pilas_ADT Pila = new Pilas_ADT(); //Constructor
        Pila.push(22); //Agrega un elemento al final de la pila.
        Pila.push(33);
        Pila.push(44);
        Pila.push(56);
        System.out.println(Pila.peek()); //Muestra sin sacar el último elemento
        //agregado a la pila.
        Pila.transversal();
    }
}
