/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author USUARIO
 */
public class Menu {
    
    public void mostrarMenu(){
        System.out.println("\n=================== SISTEMA DE GESTIÓN DE MÚSICA =====================");
        System.out.println("1. Registrar canción en la biblioteca principal (Lista Simple / AVL / ABB)");
        System.out.println("2. Buscar canción por ID (AVL)");
        System.out.println("3. Agregar canción a la cola de reproducción (Cola)");
        System.out.println("4. Agregar canción a favoritos (Cola con prioridad)");
        System.out.println("5. Reproducir siguiente canción (Desencolar y apilar en historial)");
        System.out.println("6. Reproducir canción anterior (Desapilar de historial)");
        System.out.println("7. Ver playlist de pistas reproducidas (Lista Doble)");
        System.out.println("8. Ver historial de canciones escuchadas (Pila)");
        System.out.println("9. Explorar canciones por géneros musicales (Árbol general)");
        System.out.println("10. Ver biblioteca completa ordenada (Recorridos de Árbol AVL)");
        System.out.println("11. Salir del sistema");
        System.out.print("Seleccione una opción: ");
    }
    
    
}
