/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author EBER
 */
public class GestorMusica {

    ListaSimple canciones = new ListaSimple();
    ListaDoble playlist = new ListaDoble();
    Cola cola = new Cola();
    Pila historial = new Pila();
    ColaPrioridad prioridad = new ColaPrioridad();

    public void agregarCancion(String nombre) {
        canciones.agregar(nombre);
    }

    public void agregarPlaylist(String nombre) {
        playlist.agregar(nombre);
    }

    public void agregarCola(String nombre) {
        cola.agregar(nombre);
    }

    public void agregarHistorial(String nombre) {
        historial.push(nombre);
    }

    public void agregarPrioridad(String nombre) {
        prioridad.agregar(nombre);
    }

    public String atenderCola() {
        return cola.remover();
    }

    public String atenderHistorial() {
        return historial.pop();
    }

    public void atenderPrioridad() {
        prioridad.atender();
    }


    public void mostrarTodo() {

        System.out.println("\nLISTA SIMPLE");
        canciones.mostrar();

        System.out.println("\nPLAYLIST");
        playlist.mostrar();

        System.out.println("\nCOLA");
        cola.mostrar();

        System.out.println("\nHISTORIAL");
        historial.mostrarPila();

        System.out.println("\nPRIORIDAD");
        prioridad.mostrar();
    }
}