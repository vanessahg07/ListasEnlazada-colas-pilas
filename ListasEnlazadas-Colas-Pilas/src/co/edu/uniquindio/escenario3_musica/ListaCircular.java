package co.edu.uniquindio.escenario3_musica;

public class ListaCircular <T>{

    private Nodo<T> actual;
    private int tam;

    public ListaCircular(){
        actual = null;
        tam = 0;
    }
    
    // Agregar canción al final de la lista
    public void agregarCancion(T valor){
        Nodo<T> nuevo = new Nodo<>(valor);
        
        if(actual == null && tam == 0){
            // Primera canción, apunta a sí misma
            actual = nuevo;
            nuevo.setProximo(actual);
        } else {
            // Buscar el último nodo
            Nodo<T> temp = actual;
            while(temp.getProximo() != actual){
                temp = temp.getProximo();
            }
            temp.setProximo(nuevo);
            nuevo.setProximo(actual);
        }
        tam++;
    }
    
    // Avanzar a la siguiente canción
    public T siguienteCancion(){
        if(actual == null){
            return null;
        }
        actual = actual.getProximo();
        return actual.getValor();
    }
    
    // Mostrar canción actual
    public T cancionActual(){
        if(actual == null){
            return null;
        }
        return actual.getValor();
    }
    
    // Eliminar una canción por nombre
    public boolean eliminarCancion(T valor){
        if(actual == null){
            return false;
        }
        
        // Caso especial: solo una canción en la lista
        if(tam == 1 && actual.getValor().equals(valor)){
            actual = null;
            tam--;
            return true;
        }
        
        Nodo<T> temp = actual;
        Nodo<T> anterior = null;
        
        // Buscar la canción a eliminar
        do {
            if(temp.getValor().equals(valor)){
                if(anterior == null){
                    // Eliminar el nodo actual, mover actual al siguiente
                    Nodo<T> ultimo = actual;
                    while(ultimo.getProximo() != actual){
                        ultimo = ultimo.getProximo();
                    }
                    actual = actual.getProximo();
                    ultimo.setProximo(actual);
                } else {
                    anterior.setProximo(temp.getProximo());
                    if(temp == actual){
                        actual = actual.getProximo();
                    }
                }
                tam--;
                return true;
            }
            anterior = temp;
            temp = temp.getProximo();
        } while(temp != actual);
        
        return false;
    }
    
    // Mostrar todas las canciones
    public String mostrarLista(){
        if(actual == null){
            return "No hay canciones en la lista";
        }
        
        StringBuilder sb = new StringBuilder();
        Nodo<T> temp = actual;
        int numero = 1;
        
        do {
            if(temp == actual){
                sb.append(numero).append(". [▶ REPRODUCIENDO] ").append(temp.getValor()).append("\n");
            } else {
                sb.append(numero).append(". ").append(temp.getValor()).append("\n");
            }
            temp = temp.getProximo();
            numero++;
        } while(temp != actual);
        
        return sb.toString();
    }
    
    // Verificar si la lista está vacía
    public boolean esVacia(){
        return actual == null && tam == 0;
    }
    
    // Obtener tamaño de la lista
    public int getTam(){
        return tam;
    }
}