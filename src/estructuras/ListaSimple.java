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

public class ListaSimple {

    class Nodo {

        Cancion cancion;
        Nodo siguiente;

        Nodo(Cancion cancion) {
            this.cancion = cancion;
        }

    }

    private Nodo cabeza;

    public void agregar(Cancion cancion) {

        Nodo nuevo = new Nodo(cancion);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo aux = cabeza;

        while (aux.siguiente != null)
            aux = aux.siguiente;

        aux.siguiente = nuevo;

    }

    public Cancion buscar(int id) {

        Nodo aux = cabeza;

        while (aux != null) {

            if (aux.cancion.getId() == id)
                return aux.cancion;

            aux = aux.siguiente;

        }

        return null;

    }

    public boolean eliminar(int id) {

        if (cabeza == null)
            return false;

        if (cabeza.cancion.getId() == id) {

            cabeza = cabeza.siguiente;
            return true;

        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;

        while (actual != null) {

            if (actual.cancion.getId() == id) {

                anterior.siguiente = actual.siguiente;
                return true;

            }

            anterior = actual;
            actual = actual.siguiente;

        }

        return false;

    }

    public boolean estaVacia() {

        return cabeza == null;

    }

    public void mostrar() {

        if (estaVacia()) {

            System.out.println("No existen canciones.");
            return;

        }

        Nodo aux = cabeza;

        while (aux != null) {

            System.out.println(aux.cancion);

            aux = aux.siguiente;

        }

    }

}