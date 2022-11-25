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
public class LSL_ADT<T> {

    Nodo<T> cabeza;
    int rozmiar;

    public LSL_ADT() {
        this.cabeza = null;
        this.rozmiar = 0;
    }

    public boolean estaVacia() {
        return this.cabeza == null;
    }

    public int getRozmiar() {
        Nodo Aux = cabeza;
        if (this.estaVacia()) {
            return 0;
        } else {
            rozmiar = 1;
            while (Aux.getSiguiente() != null) {
                Aux = Aux.getSiguiente();
                rozmiar++;
            }
        }
        return this.rozmiar;
    }

    public T regresarFinal() {
        if (this.estaVacia()) {
            return null;
        } else {
            Nodo Aux = cabeza;
            while (Aux.getSiguiente() != null) {
                Aux = Aux.getSiguiente();
            }
            return (T) Aux.getDato();
        }
    }

    public T regresarInicio() {
        if (this.estaVacia()) {
            return null;
        } else {
            Nodo Aux = cabeza;
            return (T)Aux.getDato();
        }
    }

    public void agregarAlFinal(T dato) {
        Nodo Aux = new Nodo(dato);
        if (this.estaVacia()) {
            this.cabeza = Aux;
        } else {
            Nodo Temp = cabeza;
            while (Temp.getSiguiente() != null) {
                Temp = Temp.getSiguiente();
            }
            Temp.setSiguiente(Aux);
        }
    }

    public void agregarAlInicio(T dato) {
        Nodo Aux = new Nodo(dato);
        if (this.estaVacia()) {
            this.cabeza = Aux;
        } else {
            Aux.setSiguiente(this.cabeza);
            this.cabeza = Aux;
        }
    }

    public void agregarDespuesDe(int posición, T dato) {
        Nodo Aux = new Nodo(dato);
        Nodo Tem = this.cabeza;
        for (int contador = 1; contador <= posición - 1; contador++) {
            Tem = Tem.getSiguiente();
        }
        Aux.setSiguiente(Tem.getSiguiente());
        Tem.setSiguiente(Aux);
    }

    public void eliminar(int posición) {
        Nodo Temp = this.cabeza;
        if (this.estaVacia()) {
            System.out.println("Lista vacia, llénala primero alcornoque");
        } else {
            if (posición > cabeza.toString().length()) {
                System.out.println("La posición introducida no existe en esta lista, alcornoque");
            } else {
                for (int contador = 1; contador < posición - 1; contador++) {
                    Temp = Temp.getSiguiente();
                }
            }
        }
        Temp.setSiguiente(Temp.getSiguiente().getSiguiente());
    }

    public void eliminarElPrimero() {
        Nodo Aux = cabeza;
        if (this.estaVacia()) {
            cabeza = Aux;
        } else {
            cabeza = Aux.getSiguiente();
        }
    }

    public void eliminarElFinal() {
        Nodo Aux = cabeza;
        if (this.estaVacia()) {
            cabeza = Aux;
        } else {
            while (Aux.getSiguiente().getSiguiente() != null) {
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(null);
        }
    }

    public int buscarValor(T dato) {
        Nodo Aux = cabeza;
        int Posición = 1;
        if (this.estaVacia()) {
            System.out.println("No hay valor, la cadena está vacía.");
        } else {
            while (Aux.getDato() != dato) {
                if (Aux.getDato() == null) {
                    System.out.println("No se encontró ese dato.");
                    return 0;
                } else {
                    Aux = Aux.getSiguiente();
                    Posición++;
                }
            }
        }
        return Posición;
    }

    public void actualizarValor(T dato, T actualizado) {
        Nodo Aux = cabeza;
        while (Aux.getSiguiente() != dato) {
            Aux = Aux.getSiguiente();
        }
        Aux.setDato(actualizado);
    }

    public void transversal() {
        Nodo nodo_actual = this.cabeza;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("");
    }

    public void transversalPila() {
        Nodo nodo_actual = this.cabeza;
        while (nodo_actual != null) {
            System.out.println(nodo_actual.toStringPila());
            nodo_actual = nodo_actual.getSiguiente();
        }
    }

    @Override
    public String toString() {
        return "LSL_ADT{" + "cabeza=" + cabeza + '}';
    }

    public static void main(String[] args) {
        LSL_ADT cabeza = new LSL_ADT();
        cabeza.agregarAlFinal(18);
        cabeza.agregarAlFinal(23);
        cabeza.agregarAlFinal(14);
        cabeza.agregarAlFinal(8);
        cabeza.agregarAlFinal(27);
        cabeza.transversal();
        cabeza.agregarAlInicio(303);
        cabeza.transversal();
        cabeza.eliminar(3);
        System.out.println(cabeza.buscarValor(18));
        System.out.println(cabeza.buscarValor(8));
        cabeza.eliminarElFinal();
        cabeza.transversal();
        System.out.println(cabeza.buscarValor(18));
        System.out.println(cabeza.toString());
        //System.out.println(cabeza.toString());
    }
}
