// Tenorio Castilla Carlos Yael
/* Fecha de entrega:
Propósito:
     HashTAbleADT( table_size).- Constructor del hash table
     Add(key , value).- Agrega una nueva entrada a la tabla.
     valueOf( key).- regresa el valor asociado a una llave.
     Remove( key).- Elimina de la tabla el valor asocioado a la llave.
 */
package com.urbenia.arreglos_adt;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yael_
 * @param <T>
 */
public class TablaHash_ADT<T> {

    Arreglos_ADT<ArrayList> Tablash;
    int rozmiar;

    public TablaHash_ADT(int Rozmiar) {
        this.rozmiar = Rozmiar;
        if (rozmiar < 7) {
            this.rozmiar = 7;
            Tablash = new Arreglos_ADT(rozmiar);
        } else {
            /*
            Los números primos son aquellos que solo son divisibles entre 
            ellos mismos y el 1, es decir, que si intentamos dividirlos por 
            cualquier otro número, el resultado no es entero. Dicho de otra 
            forma, si haces la división por cualquier número que no sea 1 o 
            él mismo, se obtiene un resto distinto de cero.
            */
            double ayu = rozmiar % 2;
            if ((rozmiar % 2) == 0) { //Si el resto es igual a cero, entonces es compuesto.
                this.rozmiar = rozmiar + 1;
                Tablash = new Arreglos_ADT(rozmiar);
            } else { //Si el resto es distinto de cero, entonces es par.
                Tablash = new Arreglos_ADT(rozmiar);
            }

        }
        for (int F = 0; F < rozmiar; F++) { //Esto llena la tabla.
            Tablash.setItem(F, new ArrayList());
        }
    }

    public void agregar(int llave, T valor) {
        int posición = llave % rozmiar;
        Tablash.getItem(posición).add(valor);
    }

    public T valorDe(int llave) {
        int posición = llave % rozmiar;
        Object buscar;
        Object encontrado = null;

        if (Tablash.getItem(posición).size() == 1) {
            return (T) Tablash.getItem(posición).get(0);
        } else {
            buscar = JOptionPane.showInputDialog(null,
                    "Hay más de un elemento en ese lugar, ¿Qué estás buscando? ");
            for (int Q = 0; Q < Tablash.getItem(posición).size(); Q++) {
                if (Tablash.getItem(posición).get(Q).equals(buscar)) {
                    encontrado = Tablash.getItem(posición).get(Q);
                    System.out.println("En la posición " + Q);
                }
            }
        }
        return (T) encontrado;
    }

    public void eliminar(int llave) {
        int posición = llave % rozmiar;
        Object buscar;
        if (Tablash.getItem(posición).size() == 1) {
            Tablash.getItem(posición).remove(0);
        } else {
            buscar = JOptionPane.showInputDialog(null,
                    "Hay más de un elemento en ese lugar, ¿Qué estás buscando? ");
            for (int Q = 0; Q < Tablash.getItem(posición).size(); Q++) {
                if (Tablash.getItem(posición).get(Q).equals(buscar)) {
                    Tablash.getItem(posición).remove(Q);
                }
            }
        }
    }

    public static void main(String[] args) {
        TablaHash_ADT Tab = new TablaHash_ADT(9);
        Tab.agregar(0000, "Torrente");
        Tab.agregar(0001, "Paty");
        Tab.agregar(0002, "Frye");
        Tab.agregar(0003, "12:03 am");
        Tab.agregar(0007, "Steady Holiday");
        Tab.agregar(0000, "Ya lo ves, la vida es así"); //No debería tener la misma llave pero es para probar en un mismo lugar.
        System.out.println(Tab.valorDe(0007));
        Tab.eliminar(0007);
        System.out.println("Solo estoy de paso. Compermiso.");
    }
}
