//Tenorio Castilla Carlos Yael
/*Fecha de entrega: 26 de agosto de 2022
Propósito: 
Escribir el código fuente del ADT arreglo con las siguientes características:
- Los elementos del arreglo deben ser accesibles por un índice.
- Los elementos deben ser de cualquier tipo.
- Debe contener los siguientes métodos específicos:
    - Array( tamaño ) - Constructor de un tamaño específico del arreglo.
    - getItem( index ) - Obtener el elemento den la posición específica.
    - setItem( dato, index ) - Establecer un elemento en la posición establecida.
    - getLength() - Obtener el tamaño del arreglo.
    - clear( dato ) - Establece todos los valores del ADT al valor enviado en dato.
    - getIterator - Regresa el iterador del ADT.
 */
package com.urbenia.arreglos_adt;

import java.util.ArrayList;

/**
 * @author Tenorio Castilla Carlos Yael (Torrente)
 * @param <T>
 */
public class Arreglos_ADT<T> {

    public static void main(String[] args) {
        Arreglos_ADT febrero = new Arreglos_ADT(5);
        febrero.setItem(0, febrero);
        febrero.clear('.');
        System.out.println(febrero.getItem(0));
    }

    int rozmiar; //Rozmiar es tamaño en polaco.
    private ArrayList<T> datos;

    public Arreglos_ADT(int rozmiar) { //Constructor
        this.rozmiar = rozmiar;
        this.datos = new ArrayList<>(rozmiar);
        for (int j = 0; j < rozmiar; j++) {
            datos.add(null);
        }
    }

    public T getItem(int Indice) { //Getter
        if (Indice >= 0 && Indice < this.rozmiar) {
            return datos.get(Indice);
        }
        return null;
    }

    public void setItem(int Indice, T Elemento) { //Setter
        if (Indice >= 0 && Indice < this.rozmiar) {
            datos.set(Indice, Elemento);
        } else {
            System.out.println("No existe tal indice en este arreglo.");
        }
    }

    public int getLenght() { //Get Lenght
        return datos.size();
    }

    public void clear(T Elemento) { //Clear
        for (int i = 0; i < datos.size(); i++) {
            datos.set(i, Elemento);
        }
    }
}
