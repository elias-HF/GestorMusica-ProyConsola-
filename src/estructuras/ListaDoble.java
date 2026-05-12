/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author EBER
 */
public class ListaDoble {

    class Nodo {
        String cancion;
        Nodo siguiente;
        Nodo anterior;

        Nodo(String cancion) {
            this.cancion = cancion;
        }
    }

    private Nodo cabeza;

    public void agregar(String cancion) {
        Nodo nuevo = new Nodo(cancion);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
            nuevo.anterior = aux;
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
