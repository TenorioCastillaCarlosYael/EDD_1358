//Tenorio Castilla Carlos Yael
/*Fecha de entrega: 14 de Noviembre
Propósito: 
Crear un proyecto Java que implemente una Clase para el ADT Colas.
Debe contener los métodos que se encuentran descritos en las diapositivas.
    Colas() -> Constructor
    is_empty() -> ¿Está vacía?
    length() -> Número de elementos en la cola.
    enqueue( elem ) -> Ingresa un elemento al final.
    dequeue() -> Saca el elemento que se encuentra el frente de la estructura.
    to_string() -> También opcional para mostrar el estado actual de la cola.
Deberá contener una clase Main donde se ponga a prueba dicha estructura.

Subirán la carpeta del proyecto a su repositorio Github y la entrega será el link del mismo.
 */
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 * @param <T>
 */
public class Cola_ADT<T> {

    LSL_ADT kola;

    public Cola_ADT() {
        this.kola = new LSL_ADT();
    }

    public boolean estaVacia() {
        return this.kola.estaVacia();
    }

    public int getRozmiar() {
        return this.kola.getRozmiar();
    }

    public void enqueue(T valor) {
        this.kola.agregarAlFinal(valor);
    }

    public T dequeue() {
        Object Ayuda = this.kola.regresarInicio();
        kola.eliminarElPrimero();
        return (T) Ayuda;
    }

    public void transversal() {
        this.kola.transversal();
    }

    @Override
    public String toString() {
        return "Cola_ADT{" + "kola=" + (T) kola + '}';
    }

    public static void main(String[] args) {
        Cola_ADT Prueba = new Cola_ADT();
        Prueba.enqueue(18);
        Prueba.enqueue("HOLLLLLLLA");
        Prueba.enqueue('¿');
        Prueba.enqueue("kabsdbasj");
        Prueba.enqueue(70);
        Prueba.enqueue(70 + "'s");
        System.out.println(Prueba.getRozmiar());
        Prueba.transversal();
        System.out.println(Prueba.toString());
        Prueba.dequeue();
        System.out.println(Prueba.toString());
        Prueba.dequeue();
        Prueba.transversal();
    }
}
