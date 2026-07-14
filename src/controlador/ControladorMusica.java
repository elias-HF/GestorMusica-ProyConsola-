
package controlador;

import java.util.Scanner;
import modelo.Cancion;
import service.GestorMusica;
import vista.Menu;

/**
 *
 * @author USUARIO
 */
public class ControladorMusica {
    private GestorMusica gestor;
    private Menu vistaMenu;
    private Scanner teclado;

    public ControladorMusica() {
        this.gestor = new GestorMusica();
        this.vistaMenu = new Menu();
        this.teclado = new Scanner(System.in);
        cargarCancionesDemo(); // Carga inicial para que el sistema empiece con datos
    }

    private void cargarCancionesDemo() {
        System.out.println("============================= CANCIONES REGISTRADAS ========================");
        gestor.registrarCancion("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354, "Rock", 5);
        gestor.registrarCancion("Billie Jean", "Michael Jackson", "Thriller", 294, "Pop", 4);
        gestor.registrarCancion("Monster", "Skillet", "Awake", 178, "Rock", 5);
        gestor.registrarCancion("My Time", "Royal Deluxe", "My Time", 191, "Rock", 5);
    }

    public void iniciar() {
        int opcion = 0;
        do {
            vistaMenu.mostrarMenu();
            try {
                opcion = Integer.parseInt(teclado.nextLine());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Por favor, ingrese un número válido.");
            }
        } while (opcion != 11);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("\n--- REGISTRAR NUEVA CANCIÓN ---");
                System.out.print("Título: ");
                String titulo = teclado.nextLine();
                System.out.print("Artista: ");
                String artista = teclado.nextLine();
                System.out.print("Álbum: ");
                String album = teclado.nextLine();
                System.out.print("Duración (segundos): ");
                int duracion = Integer.parseInt(teclado.nextLine());
                System.out.print("Género (Rock, Pop, Salsa, etc.): ");
                String genero = teclado.nextLine();
                System.out.print("Prioridad (Favorito: 1 al 5): ");
                int prioridad = Integer.parseInt(teclado.nextLine());
                
                gestor.registrarCancion(titulo, artista, album, duracion, genero, prioridad);
                break;

            case 2:
                System.out.print("\nIngrese el ID de la canción a buscar: ");
                int idBuscar = Integer.parseInt(teclado.nextLine());
                Cancion encontrada = gestor.buscarPorId(idBuscar);
                if (encontrada != null) {
                    System.out.println("Canción encontrada: " + encontrada);
                } else {
                    System.out.println("No se encontró ninguna canción con ID: " + idBuscar);
                }
                break;

            case 3:
                System.out.print("\nIngrese el ID de la canción para agregar a la cola de reproducción: ");
                int idCola = Integer.parseInt(teclado.nextLine());
                gestor.agregarACola(idCola);
                break;

            case 4:
                System.out.print("\nIngrese el ID de la canción para marcar como favorita (Cola Prioridad): ");
                int idFav = Integer.parseInt(teclado.nextLine());
                gestor.agregarAFavoritos(idFav);
                break;

            case 5:
                System.out.println("\n--- REPRODUCIENDO SIGUIENTE CANCIÓN ---");
                gestor.reproducirSiguiente();
                break;

            case 6:
                System.out.println("\n--- REPRODUCIENDO CANCIÓN ANTERIOR ---");
                gestor.reproducirAnterior();
                break;

            case 7:
                gestor.verPlaylist();
                break;

            case 8:
                gestor.verHistorial();
                break;

            case 9:
                gestor.explorarGeneros();
                break;

            case 10:
                gestor.verBibliotecaOrdenada();
                break;

            case 11:
                System.out.println("Saliendo del sistema de gestión de música...");
                break;

            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}
