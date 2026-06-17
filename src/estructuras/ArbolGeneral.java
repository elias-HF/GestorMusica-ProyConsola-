
package estructuras;

import java.util.ArrayList;
import java.util.List;
import modelo.Cancion;


public class ArbolGeneral {
    
    Nodo raiz;

    public ArbolGeneral(Nodo raiz) {
        this.raiz = null;
    }
    
    
    
    //en Lugar de usar un Nodo se puede usar un ArrayList
    private class Nodo{
        private Nodo padre;
        //una lista para almacenar los hijos 
        private List<Nodo> hijos;
        private int llave;
        private Cancion contenido;

        public Nodo( int indice) {
            this.padre = null;
            this.hijos = new ArrayList<>();  //se comienza la lista vacia
            this.llave = indice;
            this.contenido = null;
        }
        
        public boolean insertar(int llavePadre, int nuevaLlave, Cancion c) {
            Nodo nuevo = new Nodo(nuevaLlave);
            nuevo.contenido = c;
            
            //si el arbol es nuevo, es decir esta vacio
            if(raiz==null){
                raiz = nuevo;
                return true;
            }
            
            Nodo padre = buscarNodo(raiz, llavePadre); //buscamos el nodo padre donde vamos a colocar el nuevo nodo.
            if(padre != null){
                nuevo.padre = padre;
                padre.hijos.add(nuevo); //se añade a la lista de hijos
                return true;
            }
            
            return false; //no se encontro el padre.
        }
        //metodo auxiliar recursivo
        public Nodo buscarNodo(Nodo actual,int i){
            if(actual == null){
                return null;
            }
            if(actual.llave == i){
                return actual;
            }
            
            for(Nodo hijo:actual.hijos){
                Nodo encontrado = buscarNodo(actual,actual.llave);
                
                if(encontrado != null){
                    return encontrado; 
                }
            }
            
            return null;
        }
        
        public Cancion buscar(int i){
            Nodo nodo = buscarNodo(raiz, i);
            return (nodo != null) ? nodo.contenido : null ;  //usamos un operador terminario, que en caso de que este vacio retorne null, sino returna la cancion.
        }
        
        public boolean eliminar(int i){
            if(raiz == null){
                return false;
            }
            if(raiz.llave == i){
                raiz=null; //si es la llave borramos todo
                return true;
            }
            
            Nodo nodoAEliminar = buscarNodo(raiz,i);
            if(nodoAEliminar != null){
                Nodo padre = nodoAEliminar.padre;
                padre.hijos.remove(nodoAEliminar); 
                return true;
            }
            
            return false;
        }
        
    }
}
