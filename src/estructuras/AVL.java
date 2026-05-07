
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
    //metodos para hacer las rotaciones (LL,RR,LR,RL).
    private Nodo rotarDerecha(Nodo y){
        
        Nodo x = y.izquierda;
        Nodo T2 = x.derecha;
        
        x.derecha = y;
        y.izquierda = T2;
        
        actualizarAltura(y);
        actualizarAltura(x);
        
        return x;
    }
    private Nodo rotarIzquierda(Nodo x){
        //la raiz del nodo Y va a ser el hijo derecho del nodo x.
        Nodo y = x.derecha;
        //Nodo temporal para guardar el otro valor, como un subarbol, que debe recolocarse despues de la rotacion.
        Nodo T2 = y.izquierda;
        
        //rotacion
        //el hijo izquierdo de y va a ser la raiz de x.
        y.izquierda = x;
        x.derecha = T2;
        
        actualizarAltura(x);
        actualizarAltura(y);
        
        //nueva raiz
        return y;
    }
    
    //si el arbol esta desbalanceado necesita ser balanceado.
    
    public Nodo insertarConRotaciones(Nodo n, int i, Cancion c){
        
        if(n == null){
            Nodo nuevoNodo = new Nodo(i);
            nuevoNodo.contenido = c;
            return nuevoNodo;
        }
        
        if(i < n.llave){
            n.izquierda = insertarConRotaciones(n.izquierda,i,c);
        }else{
            n.derecha = insertarConRotaciones(n.derecha,i,c);
        }
        
        actualizarAltura(n);
        
        int balance = obtenerBalance(n);
        
        
        //Comprobaciones para saber que tipo de rotacion utilizara.
        
        //Rotacion Simple derecha(LL)
        if(balance > 1 && i < n.izquierda.llave ){
            return rotarDerecha(n);
        }
        //Rotacion Simple izquierda(RR)
        if(balance < -1 && i > n.derecha.llave){
            return rotarIzquierda(n);
        }
        //Rotacion Double Izquierda - Derecha(LR)
        if(balance > 1 && i > n.izquierda.llave ){
            n.izquierda = rotarIzquierda(n.izquierda);
            return rotarDerecha(n);
        }
        //Rotacion Doble Derecha - Izquierda(RL)
        if(balance < -1 && i < n.derecha.llave){
            n.derecha = rotarDerecha(n.derecha);
            return rotarIzquierda(n);
        }
        
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
    //para que el usuario no vea cosas innecesarias.
    public void recorrerInOrder(){
        recorrerInOrder(raiz);
    }
    

    public Nodo getRaiz()           {return raiz;}

    public void setRaiz(Nodo raiz)  {this.raiz = raiz;}
    
    
}
