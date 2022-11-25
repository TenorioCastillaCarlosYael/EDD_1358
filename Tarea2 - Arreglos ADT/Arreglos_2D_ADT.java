//Tenorio Castilla Carlos Yael
/*Fecha de entrega: S/F
Propósito: 
Escribir el código fuente del Arreglo 2D de ADT'S:
- Debe contener los siguientes métodos específicos:
    - Array( tamaño ) - Constructor de un tamaño específico del arreglo.
    - getItem( index ) - Obtener el elemento den la posición específica.
    - setItem( dato, index ) - Establecer un elemento en la posición establecida.
    - getLength() - Obtener el tamaño del arreglo.
    - clear( dato ) - Establece todos los valores del ADT al valor enviado en dato.
 */
package com.urbenia.arreglos_adt;

/**
 * @author yael_
 * @param <T>
 */
public class Arreglos_2D_ADT<T> {

    public static void main(String[] args) {
        Arreglos_2D_ADT Septiembre = new Arreglos_2D_ADT(10, 10);

        for (int Fik = 0; Fik < Septiembre.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Septiembre.get_Columnas(); Cok++) {
                Septiembre.set_Item(Fik, Cok, '.');
            }
        }
        
        Septiembre.set_Item(8, 8, "Un 8");
        
        System.out.println(Septiembre.get_Columnas());
        System.out.println(Septiembre.get_Filas());
        for (int Fik = 0; Fik < Septiembre.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Septiembre.get_Columnas(); Cok++) {
                System.out.print(Septiembre.get_Item(Fik, Cok) + " ");
            }
            System.out.print("\n");
        }
        Septiembre.clear(8);
        for (int Fik = 0; Fik < Septiembre.get_Filas(); Fik++) {
            for (int Cok = 0; Cok < Septiembre.get_Columnas(); Cok++) {
                System.out.print(Septiembre.get_Item(Fik, Cok) + " ");
            }
            System.out.print("\n");
        }

    }

    int Filas, Columnas;
    private final Arreglos_ADT<Arreglos_ADT> Fillas;
    Arreglos_ADT<Arreglos_ADT> Item;
    Arreglos_ADT Collumnas;
    Arreglos_ADT Item2;

    public Arreglos_2D_ADT(int Fila, int Colu) { //Constructor
        this.Filas = Fila;
        this.Columnas = Colu;
        Fillas = new Arreglos_ADT(Filas);
        for (int F = 0; F < Filas; F++) {
            Fillas.setItem(F, new Arreglos_ADT(Colu));
        }
    }

    public int get_Filas() {
        return Filas;
    }

    public int get_Columnas() {
        return Columnas;
    }

    public void set_Item(int IndFil, int IndCol, T Elemento) {
        Fillas.getItem(IndFil).setItem(IndCol, Elemento);
    }

    public T get_Item(int IndFil, int IndCol) { //Creo es acá el problema
        if (IndCol >= 0 && IndCol < Columnas) {
            if (IndFil >= 0 && IndFil < Filas) {
                return (T) Fillas.getItem(IndFil).getItem(IndCol);
            }
        }
        return null;
    }

    public void clear(T Elemento) {
        for (int Posi = 0; Posi < Fillas.getLenght(); Posi++) {
            Item2.setItem(Posi, Elemento);
            Fillas.setItem(Posi, Item2);
        }
    }

    public String to_String() {
        String Strunowy = "";
        Strunowy += Fillas + "\n";
        return Strunowy;
    }
}
