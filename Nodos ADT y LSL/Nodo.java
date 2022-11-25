//Tenorio Castilla Carlos Yael
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 * @param <T>
 */
public class Nodo<T> { 

    public static void main(String[] args) {
        Nodo<Integer> cabeza = new Nodo(10, null);
        cabeza.setSiguiente(new Nodo(18, null));
        cabeza.getSiguiente().setSiguiente(new Nodo(1, null));
        System.out.println(cabeza.mostrarTodo());
    }

    private T datos;
    private Nodo<T> Siguiente;
    private int rozmiar;

    //Constructores
    public Nodo() { //Constructor por defecto
    }

    public Nodo(T dato) { //Constructor sobrecargado 1
        this.datos = dato;
    }

    public Nodo(T dato, Nodo<T> Sig) { //Constructor sobrecargado 2
        this.datos = dato;
        this.Siguiente = Sig;
        this.rozmiar = 0;
    }

//Métodos de acceso
    public Nodo<T> getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo<T> Sig) {
        this.Siguiente = Sig;
    }

    public T getDato() {
        return datos;
    }

    public void setDato(T dato) {
        this.datos = dato;
    }
    
    //Método toString()
    @Override
    public String toString() {
        return "|" + datos + "| -> ";
    }
    
    public String toStringPila(){
        return "[" + datos + "]";
    }

    public String mostrarTodo() {
        return "[Dato= " + datos + "] -> [Siguiente= " + this.getSiguiente() + "]";
    }
}
