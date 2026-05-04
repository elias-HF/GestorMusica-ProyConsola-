
package estructuras;

import modelo.Cancion;

// arbol binario de busqueda
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
    
    public Cancion buscar(int i){
        Nodo aux= raiz;
        
        while(aux != null){
            //si el indice buscado coicide con la raiz, entonces devuelve la cacion, caso contrarios empezara a buscar por la izquierda y luego la derecha.
            if(i==aux.llave){
                return aux.contenido;
            }else if(i < aux.llave){
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
        }
        //cancion no encontrada.
        return null;
    }
    

    //se econtro 3 formas de eliminar un nodo en arboles binarios: 1.eliminar solo un nodo 2. eliminar el nodo y su hijo  3.eliminar 2 hijos
    
    //Metodo para buscar el "NODO".
    public Nodo buscarNodo(int i){
        Nodo aux = raiz;
        while(aux !=null){
            if(i == aux.llave){
                return aux;
            }else if(i < aux.llave){
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
        }
        //no encuentra el nodo
        return null;
    }
    
    //metodo para encontrar el sucesor:
    
    public Nodo minimo(Nodo n){
        while(n.izquierda != null){
            n = n.izquierda;
        }
        return n;
    }
    
    public boolean eliminar(int i){
        Nodo nodo = buscarNodo(i);
        //Nodo no encontrado.
        if(nodo == null){
            return false;
        }
        //si sus nodos izq o der estan vacios, es decir si es una hoja  o tiene un hijo, entonces.
        if(nodo.izquierda == null || nodo.derecha == null){
            
            Nodo hijo;
            //aqui ve que hijo(izq o der esta vacio o lleno), identificamos al hijo
            if(nodo.izquierda != null){
                hijo = nodo.izquierda;
            }else{
                hijo = nodo.derecha;
            }
            //si el nodo que quieres  eliminar es la raiz, si es la raiz entonces el hijo se convierte en la nueva raiz.
            
            if(nodo.padre == null){
                raiz = hijo;
            }else if(nodo == nodo.padre.izquierda){
                nodo.padre.izquierda = hijo;
            }else{
                nodo.padre.derecha = hijo;
            }
            //si tiene hijo
            if(hijo != null){
                hijo.padre = nodo.padre;
            }
            
        }else{ //si tiene 2 hijos (izq y derecha no son null)
            //el sucesor va a ser el menor del lado derecho
            Nodo sucesor = minimo(nodo.derecha);
            //copiamos los datos.
            nodo.llave = sucesor.llave;
            nodo.contenido = sucesor.contenido;
            
            //eliminamos a su sucesor
            eliminar(sucesor.llave);
            
        }
        //nodo eliminado
        return true;
        
        
        
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
