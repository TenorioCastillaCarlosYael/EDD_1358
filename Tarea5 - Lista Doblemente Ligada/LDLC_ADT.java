//Tenorio Castilla Carlos Yael
/*Fecha de entrega: S/F
Propósito: 
Desarrollar y probar el funcionamiento de una lista ligada.
● ListaLigadaADT() → Constructor ----------------- Listo
● estaVacia() → esta vacía? ---------------------- Listo
● getTamanio() → regresa el número de elementos. - Listo
● agregarAlFinal(valor) → agrega el nodo al final entrando por cabeza. - Listo
● agregarAlInicio( valor ) → Agregar al inicio --- Listo
● agregarDespuésDe( referencia , valor ) → Agregar un nodo después del
nodo referencia ----------------------------------- Listo
● Eliminar( posicion ) → elimina el elemento en cierta posición. ------- Listo
● EliminarElPrimero() → elimina el primero de la lista. ---------------- Listo
● EliminarElFinal() → elimina el último ---------- Listo
● buscar( valor ) → buscar un elemento en la lista, regresa la posición(int).
--------------------------------------------------- Listo
● actualizar(a_buscar ,valor) -------------------- Listo
● transversal() -→ recorrido transversal para mostrar todos los elementos Listo
 */
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 * @param <T>
 */
public class LDLC_ADT<T> {

    NodoDoble<T> cabeza;
    NodoDoble<T> cola;
    int rozmiar;

    public LDLC_ADT() {
        this.cabeza = null;
        this.cola = null;
        this.rozmiar = 0;
    }

    public boolean estaVacia() {
        return this.cabeza == null;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void agregarAlFinal(T valor) {
        NodoDoble<T> Nuevo = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.cabeza = Nuevo;
            this.cola = Nuevo;
        } else {
            NodoDoble<T> Aux = cabeza;
            cola = Nuevo;
            cola.setAnterior(Aux);
            Aux.setSiguiente(cola);
            Aux = null;
            Nuevo = null;
        }
    }

    public void agregarAlInicio(T valor) {
        NodoDoble<T> Aux = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.cabeza = Aux;
            this.cola = Aux;
        } else {
            cabeza.setAnterior(Aux);
            Aux.setSiguiente(cabeza);
            cabeza = Aux;
        }
    }

    public void agregarDespuesDe(int posición, T valor) {
        NodoDoble Aux = new NodoDoble(valor);
        NodoDoble Tem = this.cabeza;
        for (int contador = 1; contador <= posición - 1; contador++) {
            Tem = Tem.getSiguiente();
        }
        Aux.setSiguiente(Tem.getSiguiente());
        Tem.setSiguiente(Aux);
        Tem.setAnterior(Tem.getAnterior());
    }

    public void eliminar(int posición) {
        NodoDoble Aux = cabeza;
        if (this.estaVacia()) {
            System.out.println("Lista vacia, llénala primero alcornoque");
        } else {
            if (posición > cabeza.toString().length()) {
                System.out.println("La posición introducida no existe en esta lista, alcornoque");
            } else {
                for (int contador = 1; contador < posición - 1; contador++) {
                    Aux = Aux.getSiguiente();
                }
            }
        }
        Aux.setSiguiente(Aux.getSiguiente().getSiguiente());
        Aux.setAnterior(Aux.getAnterior());
    }

    public void eliminarElPrimero() {
        NodoDoble Aux = cabeza;
        if (this.estaVacia()) {
            this.cabeza = Aux;
            this.cola = Aux;
        } else {
            cabeza = Aux.getSiguiente();
        }
    }

    public void eliminarElFinal() {
        NodoDoble Aux = cabeza;
        if (this.estaVacia()) {
            this.cabeza = Aux;
            this.cola = Aux;
        } else {
            while (Aux.getSiguiente().getSiguiente() != null) {
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(null);
        }
    }

    public int buscarValor(T valor) {
        NodoDoble Aux = cabeza;
        int posición = 1;
        if (this.estaVacia()) {
            System.out.println("No hay valor, la cadena está vacía.");
        } else {
            while (Aux.getDato() != valor) {
                if (Aux.getDato() == null) {
                    System.out.println("No se encontró ese dato.");
                    return 0;
                } else {
                    Aux = Aux.getSiguiente();
                    posición++;
                }
            }
        }
        return posición;
    }

    public void actualizarValor(T valor, T actualizado) {
        NodoDoble Aux = cabeza;
        while (Aux.getDato() != valor) {
            Aux = Aux.getSiguiente();
        }
        Aux.setDato(actualizado);
    }

    public void transversal() {
        NodoDoble nodo_actual = this.cabeza;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("");
    }

    public void transversalAtras() {
        NodoDoble nodo_actual = this.cola;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = nodo_actual.getAnterior();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LDLC_ADT cabeza = new LDLC_ADT();
        cabeza.agregarAlFinal(27);
        cabeza.agregarAlFinal(2002);
        cabeza.agregarAlInicio(25);
        cabeza.agregarAlInicio(18);
        cabeza.agregarDespuesDe(1, 20);
        cabeza.transversal();
        System.out.println(cabeza.buscarValor(25));
        cabeza.eliminar(3);
        cabeza.eliminarElFinal();
        cabeza.actualizarValor(20, 19);
        cabeza.transversal();
        cabeza.eliminarElPrimero();
        cabeza.transversal();
        cabeza.transversalAtras();
    }

}
