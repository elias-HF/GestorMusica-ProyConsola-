/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;
import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * @author EBER
 */


public class Cola {

    private Queue<String> cola = new LinkedList<>();

    public void agregar(String cancion) {
        cola.add(cancion);
    }

    public void atender() {
        if (!cola.isEmpty()) {
            System.out.println("Reproduciendo: " + cola.poll());
        }
    }

    public void mostrar() {
        System.out.println(cola);
    }
}
