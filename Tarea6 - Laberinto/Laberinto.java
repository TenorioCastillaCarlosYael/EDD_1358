//Tenorio Castilla Carlos Yael
/*
La tarea consiste en entregar un programa que pueda encontrar el camino para 
salir de un laberinto utilizando back tracking y las siguientes estructuras:

Array 2D
Pila
NOTA: También pueden utilizar otra estructura siempre y cuando lo vean conveniente.
La inicialización del laberinto tiene que hacerse desde un archivo separado por comas.
Debe estar programado en Java y la entrega será igualmente mediante link del repositorio Github que contenga el proyecto. 
 */
package com.urbenia.arreglos_adt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * @author yael_
 */
public class Laberinto {

    public static void main(String[] args) throws FileNotFoundException {
        //Leerá el archivo con un arraylist.
        File Arch = new File("C:\\Users\\yael_\\OneDrive\\Documentos\\NetBeansProjects\\Proyectos EDD - Aqui está git anclado al repositorio\\Tarea6 - Laberinto\\nivel1.dat");
        Laberinto Prueba = new Laberinto(Arch);
        TableroLab.llenarTablero(Prueba.TablaLaberinto, Prueba.OutterArray);
        Prueba.empezar(Prueba.OutterArray);
        System.out.println("Entrada:");
        TableroLab.imprimirTablero(Prueba.TablaLaberinto);
        while (TableroLab.esSalida(Prueba.TablaLaberinto, Prueba.Solución)) {
            Prueba.aplicarReglas(Prueba.TablaLaberinto);
            //TableroLab.imprimirTablero(Prueba.TablaLaberinto);
        }
        System.out.println("Final:");
        TableroLab.imprimirTablero(Prueba.TablaLaberinto);
        System.out.println("Pila de Solución:");
        Prueba.Solución.transversal();

    }

    ArrayList<ArrayList<String>> OutterArray = new ArrayList();
    String[] Lineas;
    String[] TamLis;
    Arreglos_2D_ADT TablaLaberinto;
    Pilas_ADT Solución = new Pilas_ADT();

    public Laberinto(File Arch) {
        int fila;
        int colu;
        try {
            Path Ruta = Arch.toPath();
            BufferedReader Lector = Files.newBufferedReader(Ruta);
            String Leido;
            while ((Leido = Lector.readLine()) != null) {
                Lineas = Leido.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                ArrayList<String> InnerArray = new ArrayList();
                for (String datos : Lineas) {
                    InnerArray.add(datos);
                }
                OutterArray.add(InnerArray);
            }

            fila = Integer.parseInt(OutterArray.get(0).get(0));
            colu = Integer.parseInt(OutterArray.get(1).get(0));
            TablaLaberinto = new Arreglos_2D_ADT(fila, colu);

        } catch (IOException ex) {
        }
    }

    public void empezar(ArrayList<ArrayList<String>> OutterArray) {
        //int Error = OutterArray.size() - 1;
        for (int Fik = 0; Fik < Integer.parseInt(OutterArray.get(0).get(0)); Fik++) {
            for (int Cok = 0; Cok < Integer.parseInt(OutterArray.get(1).get(0)); Cok++) {
                if (OutterArray.get(Fik + 2).get(Cok).equals("E")) {
                    Solución.push(Fik + "," + Cok);
                }
            }
        }
    }

    public void aplicarReglas(Arreglos_2D_ADT TablaLaberinto) {
        /*
        Empezará dónde le diga la pila y solo iterará a la izquierda, derecha,
        abajo o arriba en vez de un cuadrado alrededor del jugador.
        
        Todos llevan un push.
        
        Agregar una linea extra para el caso donde no pueda ir a ningún lado y
        tenga que hacer un pop().
         */
        //x es por Filas.
        //y es por Columnas.
        String Ayuda = (String)Solución.peek();
        String[] dividido = Ayuda.split(",");
        int x = Integer.parseInt(dividido[0]);
        int xAdicional = 0;
        int y = Integer.parseInt(dividido[1]);
        int yAdicional = 0;

        int IGNORAR = 0;
        //char NO = '*';

        //Ir Izquierda
        if (TablaLaberinto.get_Item(x, y - 1) != "|") {
            if (TablaLaberinto.get_Item(x, y - 1) != null) {
                if (TablaLaberinto.get_Item(x, y - 1) != "*") {
                    if (TablaLaberinto.get_Item(x, y - 1) != "^" && TablaLaberinto.get_Item(x, y - 1) != "S" && TablaLaberinto.get_Item(x, y - 1) != "X") {
                        yAdicional = y - 1;
                        Solución.push(x + "," + yAdicional);
                        TablaLaberinto.set_Item(x, y, "*");
                        IGNORAR = 1;
                    } else {
                        if (TablaLaberinto.get_Item(x, y - 1) == "S") {
                            yAdicional = y - 1;
                            Solución.push(x + "," + yAdicional);
                            TablaLaberinto.set_Item(x, yAdicional, "S");
                            TablaLaberinto.set_Item(x, y, "*");
                            IGNORAR = 1;
                        }
                    }
                }
            }
        }
        //Ir Arriba
        if (IGNORAR != 1) {
            if (TablaLaberinto.get_Item(x - 1, y) != "|") {
                if (TablaLaberinto.get_Item(x - 1, y) != null) {
                    if (TablaLaberinto.get_Item(x - 1, y) != "*") {
                        if (TablaLaberinto.get_Item(x - 1, y) != "^" && TablaLaberinto.get_Item(x - 1, y) != "S" && TablaLaberinto.get_Item(x - 1, y) != "X") {
                            xAdicional = x - 1;
                            Solución.push(xAdicional + "," + y);
                            TablaLaberinto.set_Item(x, y, "*");
                            IGNORAR = 2;
                        } else {
                            if (TablaLaberinto.get_Item(x - 1, y) == "S") {
                                xAdicional = x - 1;
                                Solución.push(xAdicional + "," + y);
                                TablaLaberinto.set_Item(xAdicional, y, "S");
                                TablaLaberinto.set_Item(x, y, "*");
                                IGNORAR = 2;
                            }
                        }
                    }
                }
            }
        }
        //Ir Derecha
        if (IGNORAR != 1 && IGNORAR != 2) {
            if (TablaLaberinto.get_Item(x, y + 1) != "|") {
                if (TablaLaberinto.get_Item(x, y + 1) != null) {
                    if (TablaLaberinto.get_Item(x, y + 1) != "*") {
                        if (TablaLaberinto.get_Item(x, y + 1) != "^" && TablaLaberinto.get_Item(x, y + 1) != "S" && TablaLaberinto.get_Item(x, y + 1) != "X") {
                            yAdicional = y + 1;
                            Solución.push(x + "," + yAdicional);
                            TablaLaberinto.set_Item(x, y, "*");
                            IGNORAR = 3;
                        } else {
                            if (TablaLaberinto.get_Item(x, y + 1) == "S") {
                                yAdicional = y + 1;
                                Solución.push(x + "," + yAdicional);
                                TablaLaberinto.set_Item(x, yAdicional, "S");
                                TablaLaberinto.set_Item(x, y, "*");
                                IGNORAR = 3;
                            }
                        }
                    }
                }
            }
        }
        //Ir Abajo
        if (IGNORAR != 1 && IGNORAR != 2 && IGNORAR != 3) {
            if (TablaLaberinto.get_Item(x + 1, y) != "|") {
                if (TablaLaberinto.get_Item(x + 1, y) != null) {
                    if (TablaLaberinto.get_Item(x + 1, y) != "*") {
                        if (TablaLaberinto.get_Item(x + 1, y) != "^" && TablaLaberinto.get_Item(x + 1, y) != "S" && TablaLaberinto.get_Item(x + 1, y) != "X") {
                            xAdicional = x + 1;
                            Solución.push(xAdicional + "," + y);
                            TablaLaberinto.set_Item(x, y, "*");
                        } else {
                            if (TablaLaberinto.get_Item(x + 1, y) == "S") {
                                xAdicional = x + 1;
                                Solución.push(xAdicional + "," + y);
                                TablaLaberinto.set_Item(xAdicional, y, "S");
                                TablaLaberinto.set_Item(x, y, "*");
                            }
                        }
                    }
                }
            }
        }
        //Caso donde está encerrado

        /* Caso 1
        Encerrado de la forma:
        |||
        | *
        |||
         */
        if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
            if (TablaLaberinto.get_Item(x, y - 1) == "|") { //Izquierda |
                if (TablaLaberinto.get_Item(x - 1, y) == "|") { //Arriba |
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 1.2
                    Encerrado de la forma:
                    |X|
                    | *
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { //Arriba X
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 1.1
                Encerrado de la forma:
                |||
                X *
                |||
                 */
            } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { //Izquierda X
                if (TablaLaberinto.get_Item(x - 1, y) == "|") { //Arriba |
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 1.5
                    Encerrado de la forma:
                    |X|
                    X *
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { //Arriba X
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
            /* Caso 1.3
            Encerrado de la forma:
            |||
            | *
            |X|
             */
        } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo X
            if (TablaLaberinto.get_Item(x, y - 1) == "|") { //Izquierda |
                if (TablaLaberinto.get_Item(x - 1, y) == "|") { //Arriba |
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { //Arriba X
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 1.4
                Encerrado de la forma:
                |||
                X *
                |X|
                 */
            } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { //Izquierda X
                if (TablaLaberinto.get_Item(x - 1, y) == "|") { //Arriba |
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 1.6
                    Encerrado de la forma:
                    |X|
                    X *
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { //Arriba X
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }

        /* Caso 2
        Encerrado de la forma:
        |||
        | |
        |*|
         */
        if (TablaLaberinto.get_Item(x, y - 1) == "|") { //Izquierda |
            if (TablaLaberinto.get_Item(x - 1, y) == "|") { //Arriba |
                if (TablaLaberinto.get_Item(x, y + 1) == "|") { //Derecha |
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 2.2
                    Encerrado de la forma:
                    |||
                    | X
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { //Derecha X
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 2.1
                Encerrado de la forma:
                |X|
                | |
                |*|
                 */
            } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { //Arriba X
                if (TablaLaberinto.get_Item(x, y + 1) == "|") { //Derecha |
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 2.5
                    Encerrado de la forma:
                    |X|
                    | X
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { //Derecha X
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }

                } else if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
            /* Caso 2.3
            Encerrado de la forma:
            |||
            X |
            |*|
             */
        } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { //Izquierda X
            if (TablaLaberinto.get_Item(x - 1, y) == "|") { //Arriba |
                if (TablaLaberinto.get_Item(x, y + 1) == "|") { //Derecha |
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { //Derecha
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 2.4
                Encerrado de la forma:
                |X|
                X |
                |*|
                 */
            } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { //Arriba X
                if (TablaLaberinto.get_Item(x, y + 1) == "|") { //Derecha |
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 2.6
                    Encerrado de la forma:
                    |X|
                    X X
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { //Derecha |
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }

        /* Caso 3
        Encerrado de la forma:
        |||
        * |
        |||
         */
        if (TablaLaberinto.get_Item(x - 1, y) == "|") { //Arriba |
            if (TablaLaberinto.get_Item(x, y + 1) == "|") { //Derecha |
                if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 3.3
                    Encerrado de la forma:
                    |||
                    * |
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo X
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 3.1
                Encerrado de la forma:
                |||
                * X
                |||
                 */
            } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { //Derecha X
                if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 3.5
                    Encerrado de la forma:
                    |||
                    * X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo X
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x + 1, y) == "*") { //Abajo *
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            } else if (TablaLaberinto.get_Item(x, y + 1) == "*") { //Derecha *
                if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 3.5
                    Encerrado de la forma:
                    |||
                    * X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo X
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x + 1, y) == "*") {
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
            /* Caso 3.2
            Encerrado de la forma:
            |X|
            * |
            |||
             */
        } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { //Arriba X
            if (TablaLaberinto.get_Item(x, y + 1) == "|") { //Derecha |
                if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo *
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 3.4
                Encerrado de la forma:
                |X|
                * X
                |||
                 */
            } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { //Derecha X
                if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 3.6
                    Encerrado de la forma:
                    |X|
                    * X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo X
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { //Izquierda *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }
        /* Caso 4
        Encerrado de la forma:
        |*|
        | |
        |||
         */
        if (TablaLaberinto.get_Item(x, y + 1) == "|") { //Derecha |
            if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
                if (TablaLaberinto.get_Item(x, y - 1) == "|") { //Izquierda |
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 4.3
                    Encerrado de la forma:
                    |*|
                    X |
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { //Izquierda X
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 4.1
                Encerrado de la forma:
                |*|
                | |
                |X|
                 */
            } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo X
                if (TablaLaberinto.get_Item(x, y - 1) == "|") { //Izquierda |
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 4.5
                    Encerrado de la forma:
                    |*|
                    X |
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { //Izquierda |
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
            /* Caso 4.2
            Encerrado de la forma:
            |*|
            | X
            |||
             */
        } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { //Derecha X
            if (TablaLaberinto.get_Item(x + 1, y) == "|") { //Abajo |
                if (TablaLaberinto.get_Item(x, y - 1) == "|") { //Izquierda |
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { //Izquierda X
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 4.4
                Encerrado de la forma:
                |*|
                | X
                |X|
                 */
            } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { //Abajo X
                if (TablaLaberinto.get_Item(x, y - 1) == "|") { //Izquierda |
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 4.6
                    Encerrado de la forma:
                    |*|
                    X X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { //Izquierda X
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { //Arriba *
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }

    }
}
