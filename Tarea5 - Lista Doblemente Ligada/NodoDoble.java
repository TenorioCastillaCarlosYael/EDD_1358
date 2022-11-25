/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 * @param <T>
 */
public class NodoDoble<T> {

    private T datos;
    private NodoDoble<T> Siguiente;
    private NodoDoble<T> Anterior;

    //Constructores
    public NodoDoble() { //Constructor por defecto
    }

    public NodoDoble(T dato) { //Constructor sobrecargado 1
        this.datos = dato;
    }

    public NodoDoble(T dato, NodoDoble<T> Sig, NodoDoble<T> Ant) { //Constructor sobrecargado 2
        this.datos = dato;
        this.Siguiente = Sig;
        this.Anterior = Ant;
    }

//Métodos de acceso
    public NodoDoble<T> getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoDoble<T> Sig) {
        this.Siguiente = Sig;
    }

    public NodoDoble<T> getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoDoble<T> Ant) {
        this.Anterior = Ant;
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
        return "|" + datos + "| <-> ";
    }

    public String toStringPila() {
        return "[" + datos + "]" + "\n";
    }

    public String mostrarTodo() {
        return "[Anterior= " + this.getAnterior() + "] <-> [Dato= " + datos + "] <-> [Siguiente= " + this.getSiguiente() + "]";
    }
}
