//Tenorio Castilla Carlos Yael
package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 */
public class ListaSimplementeLigada_Main {

    public static void main(String[] args) {
        LSL_ADT Lista = new LSL_ADT(); //Constructor
        Lista.agregarAlInicio(88); //Agrega al inicio.
        Lista.agregarAlInicio(1);
        Lista.agregarAlInicio(18);
        Lista.agregarAlFinal(10); //Agrega al final.
        Lista.agregarAlFinal(202);
        Lista.agregarAlFinal(35);
        Lista.transversal(); 
        Lista.actualizarValor(202, 2002); //Cambia el valor a buscar por otro.
        Lista.agregarDespuesDe(5, 27); //Agrega un elemento después de una posición.
        Lista.transversal();
        Lista.eliminarElFinal();
        Lista.eliminarElPrimero();
        Lista.eliminar(4);
        Lista.transversal();
    }
}
