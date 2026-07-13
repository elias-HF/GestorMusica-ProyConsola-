/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author EBER
 */
import java.util.PriorityQueue;
import modelo.Cancion;


public class ColaPrioridad {

    private PriorityQueue<Cancion> cola = new PriorityQueue<>();

    public void agregar(Cancion cancion) {
        cola.add(cancion);
    }
    public Cancion atender() {
        if (cola.isEmpty()) {
            System.out.println("La cola de prioridad está vacía.");
            return null;
        }
        Cancion cancion = cola.poll();
        System.out.println("Reproduciendo por prioridad: " + cancion);
        return cancion;
    }

    public void mostrar() {
        if (cola.isEmpty()) {
            System.out.println("Cola de prioridad vacía: []");
            return;
        }
        System.out.print("Elementos en Cola de Prioridad: " + cola);
        System.out.println();
    }
}