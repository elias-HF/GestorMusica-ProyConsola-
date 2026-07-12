
package estructuras;

import modelo.Cancion;

//es la base del arbol Binario de Busqueda pero sin ordenamientos.
public class ArbolBinario {
    
     Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }
    
     
     //maximo 2 hijos
     private class Nodo{
         private Nodo padre;
         private Nodo derecha;
         private Nodo izquierda;
         private Cancion contenido;
         private int llave;

        public Nodo(int indice) {
            this.padre = null;
            this.derecha = null;
            this.izquierda = null;
            this.contenido = null;
            this.llave = indice;
        } 
         
     }
     // necesitas bastante informacion para insertar un dato, adiferencia del ABB que ya hace los calculos internos y sabe donde colocar los Nodos.
     //tengo que ordenarlo manualmente...
     public boolean insertar(int llavePadre,char lado, int nuevaLlave, Cancion c){
         Nodo nuevo = new Nodo(nuevaLlave);
         nuevo.contenido = c;
         
         if(raiz == null){
            raiz = nuevo;
             return true;
         }
         
         Nodo padre = buscarNodo(raiz, llavePadre);
         if(padre == null){
             return false; //no existe el nodo
         }
         
         if(lado == 'I' || lado == 'i'){
             if(padre.izquierda != null){
                 return false; //el lado izquierdo ya esta ocupado
             }
             nuevo.padre = padre;
             padre.izquierda = nuevo;
             
         }else if(lado =='D' || lado == 'd'){
             if(padre.derecha != null){
                 return false; // el lado derecho ya esta ocupado
             }
             nuevo.padre = padre;
             padre.derecha = nuevo;
         }else{
             System.out.println("Error: Ingrese I o D o un lado valido.");
             return false;
         }
         return true;
     }
     //metodo auxiliar para buscar y insertar
     public Nodo buscarNodo(Nodo actual, int i){
         if(actual == null){
             return null;
         }
         
         if(actual.llave == i){
             return actual;
         }
         
         //si no es el nodo actual buscamos por toda la izquierda
         Nodo izq = buscarNodo(actual.izquierda,i);
         if(izq != null){
             return izq;
         }
         //si no esta en la izquierda buscamos por la derecha
         return buscarNodo(actual.derecha,i);
         
     }
     
     public Cancion buscar(int i){
         Nodo encontrado = buscarNodo(raiz,i);
         return (encontrado != null) ? encontrado.contenido: null;
     }
     
     public void recorridoInOrden(Nodo n){
         if(n!=null){
            //recorre de izquierda a derecha ( de menor a mayor)
            recorridoInOrden(n.izquierda);
            System.out.println("Indice: " + n.llave + " Cancion: " + n.contenido);
            recorridoInOrden(n.derecha);
            
        }
     }
}
