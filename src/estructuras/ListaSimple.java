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
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    public void agregar(Cancion cancion) {
        Nodo nuevo = new Nodo(cancion);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }
    }

    public void mostrar() {
        Nodo aux = cabeza;

        while (aux != null) {
            System.out.println("- " + aux.cancion);
            aux = aux.siguiente;
        }
    }
}
