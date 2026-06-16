/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;



/**
 *
 * @author EBER
 */


public class Cola {

    private static class Nodo {
        String dato;
        Nodo siguiente;

        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo frente;
    private Nodo fin;
    private int tamano;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    public void agregar(String elemento) {
        Nodo nuevoNodo = new Nodo(elemento);

        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
        }

        fin = nuevoNodo;
        tamano++;
        System.out.println("-> Cola: Se agregó \"" + elemento + "\" a la fila de reproducción.");
    }

    public String remover() {
        if (estaVacia()) {
            System.out.println("¡Error! La cola está vacía, no se puede remover elementos.");
            return null;
        }

        String valorFrente = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        tamano--;
        return valorFrente;
    }

    public String peek() {
        if (estaVacia()) {
            System.out.println("La cola está vacía, no hay elementos al frente.");
            return null;
        }
        return frente.dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamano() {
        return this.tamano;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Cola vacía: []");
            return;
        }
        Nodo actual = frente;
        System.out.print("Cola de Reproducción (Frente -> Fin): [ ");
        while (actual != null) {
            System.out.print("\"" + actual.dato + "\" ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }

}