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
    
    public GestorMusica(){
        canciones = new ListaSimple();
        playlist = new ListaDoble();
        cola = new Cola();
        historial = new Pila();
        prioridad = new ColaPrioridad();
        
    }
    
    //crear cancion solo con nombre
    public void agregarCancion(String nombre) {
        
        Cancion c = new Cancion(nombre);
        canciones.agregar(c);
        
    }
    
    //crear una cancion con todos sus atributos
    
    //agregar una objeto concion solo con su nombre a una lista doble de canciones.
    public void agregarPlaylist(Cancion nombre) {
        playlist.agregar(nombre);
    }

    public void agregarCola(Cancion nombre) {
        cola.agregar(nombre);
    }

    public void agregarHistorial(Cancion nombre) {
        historial.push(nombre);
    }

    public void agregarPrioridad(Cancion nombre) {
        prioridad.agregar(nombre);
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