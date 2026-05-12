/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author EBER
 */

public class test {

    public static void main(String[] args) {

        GestorMusica gestor = new GestorMusica();

        gestor.agregarCancion("Shape of You");
        gestor.agregarCancion("Blinding Lights");
        gestor.agregarCancion("Believer");

        gestor.agregarPlaylist("Despacito");
        gestor.agregarPlaylist("Levitating");

        gestor.agregarCola("Bad Habits");
        gestor.agregarCola("Stay");

        gestor.agregarHistorial("Thunder");
        gestor.agregarHistorial("Radioactive");

        gestor.agregarPrioridad("Z Song");
        gestor.agregarPrioridad("A Song");
        gestor.agregarPrioridad("M Song");

        gestor.mostrarTodo();

        System.out.println("\n--- PROBANDO COLA ---");
        gestor.cola.atender();
        gestor.cola.mostrar();

        System.out.println("\n--- PROBANDO PILA ---");
        gestor.historial.eliminar();
        gestor.historial.mostrar();

        System.out.println("\n--- PROBANDO PRIORIDAD ---");
        gestor.prioridad.atender();
        gestor.prioridad.mostrar();
    }
}