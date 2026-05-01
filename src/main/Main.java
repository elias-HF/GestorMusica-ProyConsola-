
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
    }
    
}
