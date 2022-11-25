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
public class Pilas_ADT<T> {

    LSL_ADT pilla;

    public Pilas_ADT() {
        this.pilla = new LSL_ADT();
    }

    public boolean estaVacia() {
        return this.pilla.estaVacia();
    }

    public int getRozmiar() {
        return this.pilla.getRozmiar();
    }

    public T pop() {
        Object NPOP = pilla.regresarFinal();
        this.pilla.eliminarElFinal();
        return (T)NPOP;
    }

    public T peek() {
        Object NPEEK = pilla.regresarFinal();
        return (T)NPEEK;
    }

    public void push(T valor) {
        this.pilla.agregarAlFinal(valor);
    }

    public void transversal() {
        this.pilla.transversalPila();
    }

    @Override
    public String toString() {
        return "Pilas_ADT{" + "pilla=" + pilla + '}';
    }

    public static void main(String[] args) {
        Pilas_ADT Pila1 = new Pilas_ADT();
        Pila1.push(22);
        Pila1.push(33);
        Pila1.push(44);
        Pila1.push(56);
        System.out.println(Pila1.peek());
        System.out.println(Pila1.toString());
        Pila1.transversal();
    }
}
