/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Scanner;
import modelo.Cancion;
import service.GestorMusica;
import vista.Menu;

public class ControladorMusica {

    private final Scanner sc;
    private final Menu menu;
    private final GestorMusica gestor;

    public ControladorMusica() {
        sc = new Scanner(System.in);
        menu = new Menu();
        gestor = new GestorMusica();
    }

    public void iniciar() {

        int opcion;

        do {

            menu.menuPrincipal();

            System.out.print("\nSeleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {

                case 1:
                    menuListaSimple();
                    break;

                case 2:
                    menuListaDoble();
                    break;

                case 3:
                    menuPila();
                    break;

                case 4:
                    menuCola();
                    break;


                case 5:
                    System.out.println("\nCola Prioridad (En construcción)");
                    pausa();
                    break;

                case 6:
                    System.out.println("\nÁrbol Binario (En construcción)");
                    pausa();
                    break;

                case 7:
                    System.out.println("\nABB (En construcción)");
                    pausa();
                    break;

                case 8:
                    System.out.println("\nAVL (En construcción)");
                    pausa();
                    break;

                case 9:
                    System.out.println("\nÁrbol General (En construcción)");
                    pausa();
                    break;

                case 0:
                    System.out.println("\nHasta luego.");
                    break;

                default:
                    System.out.println("\nOpción incorrecta.");
                    pausa();
            }

        } while (opcion != 0);

    }

    private void menuListaSimple() {

        int op;

        do {

            System.out.println("\n==============================");
            System.out.println("     BIBLIOTECA MUSICAL");
            System.out.println("==============================");
            System.out.println("1. Registrar canción");
            System.out.println("2. Mostrar canciones");
            System.out.println("0. Regresar");
            System.out.print("Opción: ");

            op = leerEntero();

            switch (op) {

                case 1:

                    sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Álbum: ");
                    String album = sc.nextLine();

                    System.out.print("Duración (segundos): ");
                    int duracion = leerEntero();

                    sc.nextLine();

                    System.out.print("Género: ");
                    String genero = sc.nextLine();

                    gestor.agregarCancion(
                            titulo,
                            artista,
                            album,
                            duracion,
                            genero);

                    System.out.println("\nCanción registrada correctamente.");

                    pausa();

                    break;

                case 2:

                    System.out.println();

                    gestor.mostrarBiblioteca();

                    pausa();

                    break;

            }

        } while (op != 0);

    }

    private void menuListaDoble() {

        int op;

        do {

            System.out.println("\n==============================");
            System.out.println("        PLAYLIST");
            System.out.println("==============================");
            System.out.println("1. Agregar canción a Playlist");
            System.out.println("2. Mostrar Playlist");
            System.out.println("0. Regresar");
            System.out.print("Opción: ");

            op = leerEntero();

            switch (op) {

                case 1:

                    System.out.print("Ingrese el ID de la canción: ");
                    int id = leerEntero();

                    Cancion c = gestor.getCanciones().buscar(id);

                    if (c != null) {

                        gestor.agregarPlaylist(c);
                        System.out.println("\nCanción agregada a la Playlist.");

                    } else {

                        System.out.println("\nNo existe una canción con ese ID.");

                    }

                    pausa();

                    break;

                case 2:

                    System.out.println("\n===== PLAYLIST =====");
                    gestor.mostrarPlaylist();

                    pausa();

                    break;

                case 0:
                    break;

                default:

                    System.out.println("\nOpción incorrecta.");
                    pausa();

            }

        } while (op != 0);

    }


    private void menuPila() {

        int op;

        do {

            System.out.println("\n==============================");
            System.out.println("         HISTORIAL");
            System.out.println("==============================");
            System.out.println("1. Escuchar canción (Push)");
            System.out.println("2. Ver última canción (Peek)");
            System.out.println("3. Eliminar última canción (Pop)");
            System.out.println("4. Mostrar historial");
            System.out.println("0. Regresar");
            System.out.print("Opción: ");

            op = leerEntero();

            switch (op) {

                case 1:

                    System.out.print("Ingrese el ID de la canción: ");
                    int id = leerEntero();

                    Cancion c = gestor.getCanciones().buscar(id);

                    if (c != null) {

                        gestor.agregarHistorial(c);

                    } else {

                        System.out.println("\nNo existe una canción con ese ID.");

                    }

                    pausa();

                    break;

                case 2:

                    Cancion ultima = gestor.getHistorial().peek();

                    if (ultima != null) {
                        System.out.println("\nÚltima canción escuchada:");
                        System.out.println(ultima);
                    }

                    pausa();

                    break;

                case 3:

                    Cancion eliminada = gestor.atenderHistorial();

                    if (eliminada != null) {
                        System.out.println("\nSe eliminó del historial:");
                        System.out.println(eliminada);
                    }

                    pausa();

                    break;

                case 4:

                    System.out.println();
                    gestor.mostrarHistorial();

                    pausa();

                    break;

                case 0:
                    break;

                default:

                    System.out.println("\nOpción incorrecta.");
                    pausa();

            }

        } while (op != 0);

    }

    private void menuCola() {

        int op;

        do {

            System.out.println("\n==============================");
            System.out.println("    COLA DE REPRODUCCIÓN");
            System.out.println("==============================");
            System.out.println("1. Agregar canción a la cola");
            System.out.println("2. Reproducir siguiente canción");
            System.out.println("3. Ver siguiente canción");
            System.out.println("4. Mostrar cola");
            System.out.println("0. Regresar");
            System.out.print("Opción: ");

            op = leerEntero();

            switch (op) {

                case 1:

                    System.out.print("Ingrese el ID de la canción: ");
                    int id = leerEntero();

                    Cancion c = gestor.getCanciones().buscar(id);

                    if (c != null) {

                        gestor.agregarCola(c);

                    } else {

                        System.out.println("\nNo existe una canción con ese ID.");

                    }

                    pausa();

                    break;

                case 2:

                    Cancion reproducida = gestor.atenderCola();

                    if (reproducida != null) {

                        System.out.println("\nReproduciendo:");
                        System.out.println(reproducida);


                        gestor.agregarHistorial(reproducida);

                    }

                    pausa();

                    break;

                case 3:

                    Cancion siguiente = gestor.getCola().peek();

                    if (siguiente != null) {

                        System.out.println("\nSiguiente canción:");
                        System.out.println(siguiente);

                    }

                    pausa();

                    break;

                case 4:

                    System.out.println();
                    gestor.mostrarCola();

                    pausa();

                    break;

                case 0:
                    break;

                default:

                    System.out.println("\nOpción incorrecta.");
                    pausa();

            }

        } while (op != 0);

    }


    private int leerEntero() {

        while (!sc.hasNextInt()) {

            System.out.print("Ingrese un número: ");
            sc.next();

        }

        return sc.nextInt();

    }

    private void pausa() {

        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();

    }

}