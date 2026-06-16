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


public class ColaPrioridad {

    private PriorityQueue<String> cola = new PriorityQueue<>();

    public void agregar(String cancion) {
        cola.add(cancion);
    }
    public String atender() {
        if (cola.isEmpty()) {
            System.out.println("La cola de prioridad está vacía.");
            return null;
        }
        String cancion = cola.poll();
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