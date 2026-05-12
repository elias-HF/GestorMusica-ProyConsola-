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

    public void atender() {
        if (!cola.isEmpty()) {
            System.out.println("Prioridad: " + cola.poll());
        }
    }

    public void mostrar() {
        System.out.println(cola);
    }
}