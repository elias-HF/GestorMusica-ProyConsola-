/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import modelo.Cancion;

/**
 *
 * @author EBER
 */

public class Pila {

    private static class Nodo {
        Cancion dato;
        Nodo siguiente;

        public Nodo(Cancion dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cima;
    private int tamano;

    public Pila() {
        this.cima = null;
        this.tamano = 0;
    }

    public void push(Cancion elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
        System.out.println("-> Push: Se agregó \"" + elemento + "\" al historial.");
    }

    public Cancion pop() {
        if (estaVacia()) {
            System.out.println("¡Error! El historial está vacío, no se puede hacer Pop.");
            return null;
        }
        Cancion valorCima = cima.dato; // Cambiado a String
        cima = cima.siguiente;
        tamano--;
        return valorCima;
    }

    public Cancion peek() {
        if (estaVacia()) {
            System.out.println("El historial está vacío, no hay elementos en la cima.");
            return null;
        }
        return cima.dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getTamano() {
        return this.tamano;
    }

    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Historial vacío: []");
            return;
        }
        Nodo actual = cima;
        System.out.print("Historial (Última escuchada -> Primera): [ ");
        while (actual != null) {
            System.out.print("\"" + actual.dato + "\" ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }
}