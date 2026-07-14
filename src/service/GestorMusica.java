/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

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

    private ListaSimple canciones;
    private ListaDoble playlist;
    private Cola cola;
    private Pila historial;
    private ColaPrioridad prioridad;

    public GestorMusica() {

        canciones = new ListaSimple();
        playlist = new ListaDoble();
        cola = new Cola();
        historial = new Pila();
        prioridad = new ColaPrioridad();

    }

    public void agregarCancion(String titulo) {

        Cancion c = new Cancion(titulo);
        canciones.agregar(c);

    }

    public void agregarCancion(String titulo,
                               String artista,
                               String album,
                               int duracion,
                               String genero) {

        Cancion c = new Cancion(
                titulo,
                artista,
                album,
                duracion,
                genero);

        canciones.agregar(c);

    }

    public void agregarPlaylist(Cancion c) {
        playlist.agregar(c);
    }

    public void agregarCola(Cancion c) {
        cola.agregar(c);
    }

    public void agregarHistorial(Cancion c) {
        historial.push(c);
    }

    public void agregarPrioridad(Cancion c) {
        prioridad.agregar(c);
    }

    public Cancion atenderCola() {
        return cola.remover();
    }

    public Cancion atenderHistorial() {
        return historial.pop();
    }

    public void atenderPrioridad() {
        prioridad.atender();
    }

    public void mostrarBiblioteca() {
        canciones.mostrar();
    }

    public void mostrarPlaylist() {
        playlist.mostrar();
    }

    public void mostrarCola() {
        cola.mostrar();
    }

    public void mostrarHistorial() {
        historial.mostrarPila();
    }

    public void mostrarPrioridad() {
        prioridad.mostrar();
    }

    public void mostrarTodo() {

        System.out.println("\n===== LISTA SIMPLE =====");
        canciones.mostrar();

        System.out.println("\n===== PLAYLIST =====");
        playlist.mostrar();

        System.out.println("\n===== COLA =====");
        cola.mostrar();

        System.out.println("\n===== HISTORIAL =====");
        historial.mostrarPila();

        System.out.println("\n===== PRIORIDAD =====");
        prioridad.mostrar();

    }


    public ListaSimple getCanciones() {
        return canciones;
    }

    public ListaDoble getPlaylist() {
        return playlist;
    }

    public Cola getCola() {
        return cola;
    }

    public Pila getHistorial() {
        return historial;
    }

    public ColaPrioridad getPrioridad() {
        return prioridad;
    }

}