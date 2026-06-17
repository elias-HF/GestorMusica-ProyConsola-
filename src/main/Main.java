
package main;

import estructuras.ABB;
import estructuras.AVL;
import estructuras.ArbolBinario;
import estructuras.ArbolGeneral;
import modelo.Cancion;


public class Main {

    
    public static void main(String[] args) {
       
        
        Cancion c1 = new Cancion("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        Cancion c2 = new Cancion("Billie Jean", "Michael Jackson", "Thriller", 294);
        Cancion c3 = new Cancion("Hotel California", "Eagles", "Hotel California", 390);
        Cancion c4 = new Cancion("Yesterday", "The Beatles", "Help!", 125);
        /* 
        //prueba01 - insercion y recorrido InORDER.
        ABB ab = new ABB();
        ab.insertar(30, c2);
        ab.insertar(0, c1);
        ab.insertar(10, c2);
        ab.insertar(1, c2);
        ab.insertar(7, c1);
       
        
        ab.recorridoInOrden(ab.getRaiz());
        //prueba02 - busqueda y eliminacion.
        Cancion c = ab.buscar(1);
        
        if(c !=null){
            System.out.println("Cancion encontrada: \n"+c);
        }else{
            System.out.println("Cancion no encontrada...");
        }
        
        //eliminar 
        
        if(ab.eliminar(30) !=false){
            System.out.println("Cancion eliminada");
        }else{
            System.out.println("No se pudo eliminar la cancion");
        }
        
        ab.recorridoInOrden(ab.getRaiz());
        */
        //prueba03 - ArbolAVL. insertar, buscar, eliminar y recorrido inorden.
        /*
        AVL arbolAvl = new AVL();
        
        arbolAvl.insertar(0, c1);
        arbolAvl.insertar(2, c2);
        
        arbolAvl.buscar(0);
        arbolAvl.buscar(2);
        
        arbolAvl.recorrerInOrder();
        System.out.println("Se elimino la cancion con ID 2");
        arbolAvl.eliminar(2);
        
        arbolAvl.recorrerInOrder();
        */
        //prueba03 arbolGeneral y ArbolBinario
        System.out.println("---------- Arbol Binario -----------");
        ArbolBinario arbolBinario = new ArbolBinario();
        arbolBinario.insertar(0, 'I', 10, c1);
        arbolBinario.insertar(10, 'I', 5, c2);
        arbolBinario.insertar(10, 'D', 20, c3);
        arbolBinario.insertar(5, 'D', 99, c4);
        
        System.out.println("\nRecorrido InOrden del Árbol Binario:");
        arbolBinario.recorridoInOrden(arbolBinario.getRaiz());
        
        Cancion encontradaBinario = arbolBinario.buscar(99);
        System.out.println("Encontrada: " + encontradaBinario);
        
        
        System.out.println("---------- Arbol General -----------");
        ArbolGeneral arbolGeneral = new ArbolGeneral();
        
        arbolGeneral.insertar(0, 1, null); 
        
        
        arbolGeneral.insertar(1, 100, null); 
        arbolGeneral.insertar(1, 200, null); 
        
       
        arbolGeneral.insertar(100, 101, c1); 
        arbolGeneral.insertar(100, 102, c3); 
        arbolGeneral.insertar(200, 201, c2); 

        
        System.out.println("\nRecorrido PreOrden del Árbol General:");
        arbolGeneral.recorrerPreOrder(arbolGeneral.getRaiz()); 

        // buscar una canción 
        System.out.println("\nBuscando la llave 102 en Árbol General...");
        Cancion encontradaGeneral = arbolGeneral.buscar(102);
        System.out.println("Encontrada: " + encontradaGeneral);

        // Probamos eliminar una rama completa 
        System.out.println("\nEliminando la categoría 'Pop' (Llave 200)...");
        arbolGeneral.eliminar(200);

        // Mostramos el árbol 
        System.out.println("\nÁrbol General después de la eliminación:");
        arbolGeneral.recorrerPreOrder(arbolGeneral.getRaiz());
    }
    
}
