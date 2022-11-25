//Tenorio Castilla Carlos Yael
/*Fecha de entrega: 14 de Noviembre
Propósito: 
Crear un proyecto Java que implemente una Clase para el ADT Colas de prioridad acotada.
Debe contener los métodos que se encuentran descritos en las diapositivas.
    BoundedPriorityQueue( niveles ) 🡪 Constructor
    is_empty() 🡪 ¿Está vacía?
    length() 🡪 Regresa el número de elementos en la cola con prioridad acotada.
    enqueue( prioridad , elem ) 🡪 Ingresa un elemento según su prioridad.
    dequeue() 🡪 Saca el elemento que se encuentra con mayor prioridad.
    to_string() 🡪 También opcional para mostrar el estado actual de la pila.
Deberá tener un main que simule el ejemplo de evacuación del barco de las diapositivas.

Subirán la carpeta del proyecto a su repositorio Github y la entrega será el link del mismo.
 */
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 * @param <T>
 */
public class ColaDP_ADT<T> {

    Arreglos_ADT<Cola_ADT> ColaPri;
    int Priorimom;

    public ColaDP_ADT(int MPriori) {
        ColaPri = new Arreglos_ADT(MPriori);
        this.Priorimom = MPriori;
        for (int F = 0; F < MPriori; F++) {
            ColaPri.setItem(F, new Cola_ADT());
        }
    }

    public boolean estaVacia() {
        int elem = 0;
        for (int G = 0; G < Priorimom - 1; G++) {
            if (ColaPri.getItem(G).estaVacia()) {
                elem++;
            }
        }
        return elem == 0;
    }

    public int getRozmiar() {
        int rozmiar = 0;
        Cola_ADT Ayuda;
        for (int G = 0; G < Priorimom - 1; G++) {
            Ayuda = ColaPri.getItem(G);
            rozmiar += Ayuda.getRozmiar();
        }
        return rozmiar;
    }

    public void enqueue(int Prioridad, T valor) {
        if (Prioridad >= 0 && Prioridad < Priorimom) {
            ColaPri.getItem(Prioridad).enqueue(valor);
        } else if (Prioridad > Priorimom) {
            ColaPri.getItem(Priorimom - 1).enqueue(valor);
        }
    }

    public T dequeue() {
        Object Ayuda = new Object();
        for (int K = 0; K < Priorimom; K++) {
            if (!ColaPri.getItem(K).estaVacia()) {
               Ayuda = ColaPri.getItem(K).dequeue();
            }
        }
        return (T) Ayuda;
    }

    public void transversal() {
        for (int Q = 0; Q < Priorimom; Q++) {
            System.out.print("Prioridad " + Q + " ");
            ColaPri.getItem(Q).transversal();
        }
    }

    @Override
    public String toString() {
        return "ColaDP_ADT{" + "ColaPri=" + ColaPri.toString() + '}';
    }

    public static void main(String[] args) {
        ColaDP_ADT Colita = new ColaDP_ADT(6);
        Colita.enqueue(4, "Maestre");
        Colita.enqueue(2, "Niños");
        Colita.enqueue(4, "Mecánico");
        Colita.enqueue(3, "Hombres");
        Colita.enqueue(4, "Vigía");
        Colita.enqueue(5, "Capitán");
        Colita.enqueue(4, "Timonel");
        Colita.enqueue(3, "Mujeres");
        Colita.enqueue(2, "3ra Edad");
        Colita.enqueue(1, "Niñas");
        Colita.transversal();
    }

}
