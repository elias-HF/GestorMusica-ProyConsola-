
package main;

import estructuras.ABB;
import estructuras.AVL;
import modelo.Cancion;


public class Main {

    
    public static void main(String[] args) {
       
        
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
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
        
        AVL arbolAvl = new AVL();
        
        arbolAvl.insertar(0, c1);
        arbolAvl.insertar(2, c2);
        
        arbolAvl.buscar(0);
        arbolAvl.buscar(2);
        
        arbolAvl.recorrerInOrder();
        System.out.println("Se elimino la cancion con ID 2");
        arbolAvl.eliminar(2);
        
        arbolAvl.recorrerInOrder();
    }
    
}
