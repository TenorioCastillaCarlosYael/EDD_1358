//Tenorio Castilla Carlos Yael
/*Fecha de entrega: S/F
Propósito: 
Desarrollar y probar el funcionamiento de una pila.
● Stack() → Constructor
● isEmpty() → ¿Está vacía?
● length() → Regresa el número de elementos en la pila.
● pop() → Saca el elemento del tope y lo regresa. El puntero al tope se
mueve al anterior elemento.
● peek() → Consulta el elemento en el tope, sin sacarlo.
● push( value ) → Agrega un elemento al tope de la estructura.
● isFull() → Esta operación es opcional en el caso de que se quiera
poner un límite al número de elementos. Implicaría modificación de
otros métodos.
● toString() → tambien opcional para mostrar el estado actual de la
pila.
 */
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 * @param <T>
 */
public class Pilas_Limite_ADT<T> {

    LSL_ADT Nuevo;
    int Limite;

    public Pilas_Limite_ADT(int Limite) {
        Nuevo = new LSL_ADT();
        this.Limite = Limite;
    }

    public boolean estaVacia() {
        return Nuevo.estaVacia();
    }

    public boolean estaLlena() {
        return this.getRozmiar() == Limite;
    }

    public int getRozmiar() {
        return Nuevo.getRozmiar();
    }

    public String pop() {
        String NPOP = Nuevo.regresarFinal().toString();
        this.Nuevo.eliminarElFinal();
        return NPOP;
    }

    public String peek() {
        String NPEEK = Nuevo.regresarFinal().toString();
        return NPEEK;
    }

    public void push(T valor) {
        if (this.getRozmiar() < Limite) {
            Nuevo.agregarAlFinal(valor);
        } else {
            System.out.println("No se pueden agregar más elementos, pila llena.");
        }

    }

    @Override
    public String toString() {
        return Nuevo.toString();
    }
}
