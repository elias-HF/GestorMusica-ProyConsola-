
package estructuras;

import modelo.Cancion;

//arbol binario de busqueda balanceado o avl
public class AVL {
    
    Nodo raiz;
    
    public AVL(){
        raiz=null;
    }
    
    private class Nodo{
        private Nodo derecha;
        private Nodo izquierda;
        private int llave;
        private Cancion contenido;
        private int altura;

        public Nodo(int indice) {
            llave = indice;
            derecha=null;
            izquierda = null;
            contenido=null;
            altura = 0;
        }
        
        
        
    }
    //sub metodos:
    public int obtenerAltura(Nodo n){
        if(n==null){
            return -1;
        }
        return n.altura;
    }
    
    public int obtenerBalance(Nodo n){
        if(n == null){
            return 0;
        }
        return obtenerAltura(n.izquierda)-obtenerAltura(n.derecha);
    }
    
    public void actualizarAltura(Nodo n){
        n.altura = 1+Math.max(obtenerAltura(n.izquierda), obtenerAltura(n.derecha)); //devuleve el numero mayor entre esos dos valores.
    }
    //si el arbol esta desbalanceado necesita ser balanceado.
    
    
    public Nodo insertarConRotaciones(Nodo n, int i, Cancion c){
        if(n == null){
            return new Nodo(i);
        }
        
        //comprobaciones para saber que tipo de rotacion utilizara.
        
        
        return n;
    }
    /*metodos a implementar:
    insertar
    buscar  
    eliminar
    recorrido inorden
    */
    
    public void insertar(int i, Cancion c){ //ordenado y baleanceado
        raiz =insertarConRotaciones(raiz,i,c);
    } 
    
    public Cancion buscar(int i){
        return null;
    }
    public void eliminar(int i){
    
    }
    private void recorrerInOrder(Nodo n){
        if(n!=null){
            recorrerInOrder(n.izquierda);
            System.out.println(n.llave + " " + n.contenido);
            recorrerInOrder(n.derecha);
        }
    }

    public Nodo getRaiz()           {return raiz;}

    public void setRaiz(Nodo raiz)  {this.raiz = raiz;}
    
    
}
