
package estructuras;

import modelo.Cancion;

//arbol binario de busqueda balanceado o avl
public class AVL {
    
    private Nodo raiz;
    
    public AVL(){
        raiz=null;
    }
    
    private class Nodo{
        private Nodo derecha;
        private Nodo izquierda;
        private int llave;
        private Cancion contenido;
        private int altura;

        public Nodo(int indice, Cancion c) {
            llave = indice;
            contenido=c;
            derecha = null;
            izquierda = null;
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
    
    private Nodo insertarConRotaciones(Nodo n, int i, Cancion c){
        
        if(n == null){
            return new Nodo(i,c);
             
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
    //para buscar la cancion
    public Cancion buscar(int i){
        Nodo encontrado =buscarNodo(raiz,i);
        
        if(encontrado != null){
            return encontrado.contenido;
        }
        return null;
    }
    
    //buscamos el minimo (subMetodo para eliminarAVL).
    private Nodo minimo(Nodo n){
        while(n.izquierda != null){
            n = n.izquierda;
        }
        return n;
    }
    //para buscar el nodo(se utilizara en eliminar)
    //le pasamos el nodo donde me encuentro actualmente Nodo n .
    private Nodo buscarNodo(Nodo n,int i){
        if(n == null){
            return null;
        }
        //encontramos el nodo correspondiente
        if(i == n.llave){
            return n;
        }
        //buscamos por la izquierda si la llave buscada es menor a la raiz actual, caso contrario buscamos por la derecha
        if(i<n.llave){
            return buscarNodo(n.izquierda,i);
        }else{
            return buscarNodo(n.derecha,i);
        }
        
    }
    //el metodo que usara el usuario.
    public void eliminar(int i){
        raiz = eliminarAVL(raiz,i);
    }
    //metodo recursivo.
    private Nodo eliminarAVL(Nodo n, int i){
        //buscar dentro del metodo eliminar.    paso 1
        //primero se elimina el nodo.           paso 2 
        //y luego se balancea.                  paso 3
        //busqueda..
        if (n == null){
            //nodo no encontrado
            return null;
        }
        //ningun o un solo hijo, 
        if(i < n.llave){
            n.izquierda = eliminarAVL(n.izquierda, i); 
        }else if(i >n.llave){
            n.derecha = eliminarAVL(n.derecha, i);
        }else{ // si se encontro el nodo en la busqueda.
            if(n.izquierda == null || n.derecha == null){ // 0 o 1 hijo.
                //obtenemos el hijo. // el hijo reemplaza al nodo.
                Nodo temp; 
                if(n.izquierda != null){
                    temp = n.izquierda;
                }else{
                    temp = n.derecha;
                }
                
                if(temp == null){
                    n = null;
                }else{
                    n = temp;
                }  
                
            }else{
                Nodo temp = minimo(n.derecha);
                //copiamos los datos
                n.llave = temp.llave;
                n.contenido = temp.contenido;
                
                n.derecha = eliminarAVL(n.derecha, temp.llave);
            }
            return n;
        }
           
        if(n == null){
                return null;
            }
            
        
        //balanceo.
        
        actualizarAltura(n);
        int balance = obtenerBalance(n);
        //rotaciones 
        //Rotacion Simple derecha(LL)
            if(balance > 1 && obtenerBalance(n.izquierda) >= 0 ){
                return rotarDerecha(n);
            }
            //Rotacion Simple izquierda(RR)
            if(balance < -1 && obtenerBalance(n.derecha) <= 0){
                return rotarIzquierda(n);
            }
            //Rotacion Double Izquierda - Derecha(LR)
            if(balance > 1 && obtenerBalance(n.izquierda) < 0 ){
                n.izquierda = rotarIzquierda(n.izquierda);
                return rotarDerecha(n);
            }
            //Rotacion Doble Derecha - Izquierda(RL)
            if(balance < -1 && obtenerBalance(n.derecha) > 0 ){
                n.derecha = rotarDerecha(n.derecha);
                return rotarIzquierda(n);
            }
        
        return n;
    }
    private void recorrerInOrder(Nodo n){
        if(n!=null){
            recorrerInOrder(n.izquierda);
            System.out.println("ID: "+n.llave + " | Cancion: " + n.contenido);
            recorrerInOrder(n.derecha);
        }
    }
    //para que el usuario no vea cosas innecesarias.
    public void recorrerInOrder(){
        recorrerInOrder(raiz);
    }
    

    
    
    
}
