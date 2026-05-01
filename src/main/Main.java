
package main;

import estructuras.ABB;
import modelo.Cancion;


public class Main {

    
    public static void main(String[] args) {
        
        //prueba01 - insercion y recorrido InORDER.
        ABB ab = new ABB();
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
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
        
        if(ab.eliminar(1) !=false){
            System.out.println("Cancion eliminada");
        }else{
            System.out.println("No se pudo eliminar la cancion");
        }
        
        ab.recorridoInOrden(ab.getRaiz());
    }
    
}
