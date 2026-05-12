/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author EBER
 */
import java.util.Stack;

public class Pila {

    private Stack<String> historial = new Stack<>();

    public void agregar(String cancion) {
        historial.push(cancion);
    }

    public void eliminar() {
        if (!historial.isEmpty()) {
            System.out.println("Eliminado: " + historial.pop());
        }
    }

    public void mostrar() {
        System.out.println(historial);
    }
}
