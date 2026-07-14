
package service;

import estructuras.ABB;
import estructuras.AVL;
import estructuras.ArbolGeneral;
import estructuras.Cola;
import estructuras.ColaPrioridad;
import estructuras.ListaDoble;
import estructuras.ListaSimple;
import estructuras.Pila;
import modelo.Cancion;

/**
 *
 * @author EBER
 */
public class GestorMusica {

    private ListaSimple bibliotecaPrincipal;
    private ListaDoble playlist;
    private Cola colaReproduccion;
    private Pila historial;
    private ColaPrioridad favoritos; //prioridad
    // Árboles para búsquedas y clasificaciones
    private ABB indexABB;
    private AVL indexAVL;
    private ArbolGeneral generosMusicales;
    
    public GestorMusica(){
        bibliotecaPrincipal = new ListaSimple();
        playlist = new ListaDoble();
        colaReproduccion = new Cola();
        historial = new Pila();
        favoritos = new ColaPrioridad();
        indexABB = new ABB();
        indexAVL = new AVL();
        generosMusicales = new ArbolGeneral();
        
        inicializarGenerosBase();
    }
    
    private void inicializarGenerosBase() {
        // Aqui se inicia en la Raíz id: 0 para la Música en General
        generosMusicales.insertar(0, 0, null); 
        
        // Géneros principales: Rock (id: 10), Pop (id: 20), Salsa (id: 30)
        generosMusicales.insertar(0, 10, null); // Categoría Rock
        generosMusicales.insertar(0, 20, null); // Categoría Pop
        generosMusicales.insertar(0, 30, null); // Categoría Salsa
    }
    
    //crear una cancion con todos sus atributos
    public void registrarCancion(String titulo, String artista, String album, int duracion, String genero, int prioridad){

        Cancion nueva = new Cancion(
                titulo,
                artista,
                album,
                duracion,
                genero, 
                prioridad);
        //se guarda la cancion en la lista
        
        bibliotecaPrincipal.agregar(nueva);
        //se indexa a los arboles por el ID para una mejor busqueda
        indexABB.insertar(nueva.getId(), nueva);
        indexAVL.insertar(nueva.getId(), nueva);
        
        // Se clasifica en el árbol los géneros (árbol general)
        int idGeneroPadre = 0; // Por defecto en la raíz
        if (genero.equalsIgnoreCase("Rock")) idGeneroPadre = 10;
        else if (genero.equalsIgnoreCase("Pop")) idGeneroPadre = 20;
        else if (genero.equalsIgnoreCase("Salsa")) idGeneroPadre = 30;
        
        //la canción es insertada usando su ID como llave en su rama correspondiente
        generosMusicales.insertar(idGeneroPadre, nueva.getId(), nueva);
        System.out.println("Canción \"" + titulo + "\" registrada con éxito. [ID: " + nueva.getId() + "]");
    }
    
    public Cancion buscarPorId(int id) {
        return indexAVL.buscar(id); 
    }
    
    //Agregar a la cola de reproduccion (Cola)
    public void agregarACola(int idCancion) {
        Cancion c = buscarPorId(idCancion);
        if (c != null) {
            colaReproduccion.agregar(c);
        } else {
            System.out.println("No existe ninguna canción con el ID " + idCancion);
        }
    }
    
    //Agregar a favoritos (ColaPrioridad)
    public void agregarAFavoritos(int idCancion) {
        Cancion c = buscarPorId(idCancion);
        if (c != null) {
            favoritos.agregar(c);
            System.out.println("Agregada a favoritos: " + c.getTitulo() + " (Prioridad: " + c.getPrioridad() + ")");
        } else {
            System.out.println("No existe ninguna canción con el ID " + idCancion);
        }
    }
    
    // reproducir la siguiente cancion (se quita de la cola y se coloca en el Historial)
    public void reproducirSiguiente() {
        if (colaReproduccion.estaVacia()) {
            System.out.println("La cola de reproducción está vacía. ¡Puedes agregar canciones!");
            return;
        }
        Cancion reproduciendo = colaReproduccion.remover();
        System.out.println("Reproduciendo ahora: " + reproduciendo);
        
        // Guardar en el historial (Pila)
        historial.push(reproduciendo);
        
        // se agrega a la Playlist de reproducción actual (Lista Doble)
        playlist.agregar(reproduciendo);
    }
    //lo mismo que el anterior pero alrevez
    public void reproducirAnterior() {
        if (historial.estaVacia()) {
            System.out.println("No hay canciones previas en el historial.");
            return;
        }
        // Saca la canción que se está reproduciendo actualmente
        Cancion actual = historial.pop(); 
        
        if (historial.estaVacia()) {
            System.out.println("reproduciendo nuevamente: " + actual.getTitulo() + " (Única canción en el historial)");
            historial.push(actual);
        } else {
            Cancion anterior = historial.peek(); // Mira la anterior sin sacarla de la pila
            System.out.println("Volviendo a la pista anterior: " + anterior);
        }
    }
    // ver la play list (Lista doble)
    public void verPlaylist() {
        System.out.println("\n--- LISTA DE REPRODUCCIÓN ACTUAL ---");
        playlist.mostrar();
    }
    
    //ver historial (pila)
    public void verHistorial() {
        System.out.println("\n--- HISTORIAL DE REPRODUCCIÓN (Pila LIFO) ---");
        historial.mostrarPila();
    }
    
    //se ven los genero xddd (arbol general)
    public void explorarGeneros() {
        System.out.println("\n--- EXPLORACIÓN DE MÚSICA POR GÉNEROS (Árbol General) ---");
        generosMusicales.mostrarPreOrden();
    }
    
    //se ve toda la biblioteca de canciones ya ordenada(inOrden) por el arbolAVL (AVL)
    public void verBibliotecaOrdenada() {
        System.out.println("\n--- BIBLIOTECA COMPLETA ORDENADA POR ID (Árbol Balanceado AVL) ---");
        indexAVL.mostrarInOrden();
    }
    
    //se muestra la lista principal en secuencia o secuencial
    public void verBibliotecaSecuencial() {
        System.out.println("\n--- BIBLIOTECA PRINCIPAL (Lista Simple) ---");
        bibliotecaPrincipal.mostrar();
    }
    
    //crear cancion solo con nombre
    public void agregarCancion(String nombre) {
        
        Cancion c = new Cancion(nombre);
        bibliotecaPrincipal.agregar(c);
        
    }
    



}