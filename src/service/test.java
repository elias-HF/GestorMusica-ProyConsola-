/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import estructuras.Pila;
import modelo.Cancion;

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

        System.out.println("=========================================");
        System.out.println("   ESTADO INICIAL DEL GESTOR DE MÚSICA   ");
        System.out.println("=========================================");
        gestor.mostrarTodo();

        gestor.atenderPrioridad();
        System.out.print("Estado de la ");
        gestor.prioridad.mostrar();

        System.out.println("\n--- PROBANDO COLA ---");
        System.out.println("-> Desencolando/Reproduciendo canción siguiente...");
        String cancionCola = gestor.atenderCola();
        System.out.println("<- Sonando ahora: " + cancionCola);

        System.out.println("\nVerificando el estado de la Cola después de remover:");
        System.out.print("Estado de la cola");
        gestor.cola.mostrar();

        System.out.println("\n--- PROBANDO ESTRUCTURA PILA INDEPENDIENTE ---");
        Pila miPila = new Pila();

        System.out.println("=== 1. COMPROBACIÓN INICIAL ===");
        System.out.println("¿La pila está vacía?: " + miPila.estaVacia());
        System.out.println();

        System.out.println("=== 2. OPERACIONES PUSH (Agregando canciones a la pila) ===");
        miPila.push("Bohemian Rhapsody");
        miPila.push("Back in Black");
        miPila.push("Hotel California");
        miPila.mostrarPila();
        System.out.println("Cantidad de canciones en la pila: " + miPila.getTamano());
        System.out.println();

        System.out.println("=== 3. OPERACIÓN PEEK ===");
        System.out.println("Próxima canción en la cima para reproducir: " + miPila.peek());
        System.out.println();

        System.out.println("=== 4. OPERACIONES POP ===");
        System.out.println("<- Pop ejecutado, reproduciendo: " + miPila.pop());
        miPila.mostrarPila();
        System.out.println("Nueva canción en la cima: " + miPila.peek());
        System.out.println("Canciones restantes: " + miPila.getTamano());
        System.out.println();

        System.out.println("=== 5. VACIANDO LA PILA DE REPRODUCCIÓN ===");
        System.out.println("<- Pop ejecutado, reproduciendo: " + miPila.pop());
        System.out.println("<- Pop ejecutado, reproduciendo: " + miPila.pop());
        miPila.mostrarPila();
        System.out.println("¿Se quedó sin canciones la pila?: " + miPila.estaVacia());

        System.out.println("\n=== 6. CONTROL DE ERRORES (Pila Vacía) ===");
        miPila.pop();

        System.out.println("\n--- PROBANDO HISTORIAL DEL GESTOR ---");
        System.out.println("Removiendo última canción escuchada del historial...");
        Cancion ultimaEscuchada = gestor.atenderHistorial();
        System.out.println("<- Canción removida del historial: " + ultimaEscuchada);
    }
}