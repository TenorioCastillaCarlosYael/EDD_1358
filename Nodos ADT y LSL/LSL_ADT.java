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
            return this.rozmiar;
        }
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

    public T regresarInicio() { //Adición para las colas.
        if (this.estaVacia()) {
            return null;
        } else {
            Nodo Aux = cabeza;
            return (T) Aux.getDato();
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
            rozmiar++;
        }
    }

    public void agregarAlInicio(T dato) {
        Nodo Aux = new Nodo(dato);
        if (this.estaVacia()) {
            this.cabeza = Aux;
        } else {
            Aux.setSiguiente(this.cabeza);
            this.cabeza = Aux;
            rozmiar++;
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
        rozmiar++;
    }

    public void eliminar(int posición) {
        Nodo Temp = this.cabeza;
        if (this.estaVacia()) {
            System.out.println("Lista vacia, llénala primero alcornoque");
        } else {
            if (posición > this.rozmiar) {
                System.out.println("La posición introducida no existe en esta lista, alcornoque.");
            } else {
                for (int contador = 1; contador < posición - 1; contador++) {
                    Temp = Temp.getSiguiente();
                }
            }
        }
        Temp.setSiguiente(Temp.getSiguiente().getSiguiente());
        rozmiar--;
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
            rozmiar--;
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
        while (!Aux.getDato().equals(dato)) {
            Aux = Aux.getSiguiente();
        }
        Aux.setDato(actualizado);
    }

    public void transversal() {
        Nodo nodo_actual = this.cabeza;
        while (nodo_actual != null) {
            System.out.print(nodo_actual + "->");
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("");
    }

    public void transversalPila() { //Método solo para mostrar las pilas.
        Nodo nodo_actual = this.cabeza;
        while (nodo_actual != null) {
            System.out.println(nodo_actual);
            nodo_actual = nodo_actual.getSiguiente();
        }
    }

    @Override
    public String toString() {
        return "LSL_ADT{" + "cabeza=" + cabeza + '}';
    }

    public static void main(String[] args) {
        LSL_ADT Lista = new LSL_ADT(); //Constructor
        Lista.agregarAlInicio(88); //Agrega al inicio.
        Lista.agregarAlInicio(1);
        Lista.agregarAlInicio(18);
        Lista.agregarAlFinal(10); //Agrega al final.
        Lista.agregarAlFinal(202);
        Lista.agregarAlFinal(35);
        System.out.println(Lista.getRozmiar()); //Regresa en enteros el tamaño 
        //de la lista.
        Lista.transversal(); //Muestra los valores actuales de la lista.
        Lista.actualizarValor(202, 2002); //Cambia el valor a buscar por otro.
        Lista.agregarDespuesDe(5, 27); //Agrega un elemento después de una posición.
        System.out.println(Lista.buscarValor(18)); //Regresa en enteros la posición 
        //de ese valor.
        Lista.transversal();
        Lista.eliminarElFinal();
        Lista.eliminarElPrimero();
        Lista.eliminar(4);
        Lista.transversal();
    }
}
