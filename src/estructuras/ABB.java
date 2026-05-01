
package estructuras;

import modelo.Cancion;


public class ABB {
    
    Nodo raiz;
    
    public ABB(){
        raiz=null;
    }
    //re definimos lo que es un Nodo
    private class Nodo{
        private Nodo padre;
        private Nodo derecha;
        private Nodo izquierda;
        private int llave;
        private Cancion contenido;
        
        
        public Nodo(int indice){
            llave = indice;
            derecha=null;
            izquierda = null;
            padre = null;
            contenido=null;
        }
        
        
    }
    
    /*metodos a implementar:
    insertar
    buscar  
    eliminar
    recorrido inorden
    */
    public void insertar(int i,Cancion c){
        Nodo n = new Nodo(i);
        n.contenido = c;
        
        //si la raiz es 'null'no ah empezado a crecer el arbol entonces... caso contrario creamos un nodo auxiliar para buscar donde colocarlo (derecha o izquierda)
        if(raiz==null){
            //asigna el valor de la raiz
            raiz=n;
        }else{
            Nodo aux = raiz;
            while(aux !=null){
                //lo guarda en un auxiliar antes de asignar directamente el valor, por razones de seguridad.
                n.padre = aux;
                //aqui ordena de menor a mayor los indices comparandolos..
                if(n.llave >= aux.llave ){
                    //si el indice es mayor o igual, entonces lo coloca a su derecha, caso contrario a su izquierda(partiendo desde la raiz y bajando) (ejm 1,3,5,6,19,20) 
                    aux = aux.derecha;
                }else{
                    aux = aux.izquierda;
                }
            }
            //aqui hacer lo mismo que arriba.
            if(n.llave < n.padre.llave){
                n.padre.izquierda = n;
            }else{
                n.padre.derecha = n;
            }
        }
    }
    
    public void buscar(int i){
        
    }
    public void eliminar(int i){
        
    }
    
    public void recorridoInOrden(Nodo n){
        if(n!=null){
            //recorre de izquierda a derecha ( de menor a mayor)
            recorridoInOrden(n.izquierda);
            System.out.println("Indice: " + n.llave + " Cancion: " + n.contenido);
            recorridoInOrden(n.derecha);
            
        }
    }
    
    //getter and setters

    public Nodo getRaiz()           {return raiz;}
    public void setRaiz(Nodo raiz)  {this.raiz = raiz;}
    

}
