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
                    System.out.println("\nLista Doble (En construcción)");
                    pausa();
                    break;

                case 3:
                    System.out.println("\nPila (En construcción)");
                    pausa();
                    break;

                case 4:
                    System.out.println("\nCola (En construcción)");
                    pausa();
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