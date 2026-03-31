package co.edu.uniquindio.escenario2_navegador;

public class ListaDoble <T>{

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private Nodo<T> actual;
    private int tam;

    public ListaDoble(){
        inicio = null;
        fin = null;
        actual = null;
        tam = 0;
    }
    
    // Visitar nueva página (agregar al final)
    public void visitar(T valor){
        Nodo<T> nuevo = new Nodo<>(valor);
        
        if(inicio == null && tam == 0){
            inicio = nuevo;
            fin = nuevo;
            actual = nuevo;
        } else {
            // Al visitar nueva página, se eliminan todas las páginas futuras
            if(actual != fin){
                eliminarFuturas();
            }
            nuevo.setAnterior(actual);
            actual.setProximo(nuevo);
            fin = nuevo;
            actual = nuevo;
        }
        tam++;
    }
    
    // Eliminar páginas futuras (cuando se visita nueva página después de retroceder)
    private void eliminarFuturas(){
        Nodo<T> temp = actual.getProximo();
        while(temp != null){
            Nodo<T> siguiente = temp.getProximo();
            temp.setProximo(null);
            temp.setAnterior(null);
            temp = siguiente;
            tam--;
        }
        actual.setProximo(null);
        fin = actual;
    }
    
    // Retroceder a página anterior
    public T retroceder(){
        if(actual == null || actual.getAnterior() == null){
            return null;
        }
        actual = actual.getAnterior();
        return actual.getValor();
    }
    
    // Avanzar a página siguiente
    public T avanzar(){
        if(actual == null || actual.getProximo() == null){
            return null;
        }
        actual = actual.getProximo();
        return actual.getValor();
    }
    
    // Mostrar página actual
    public T paginaActual(){
        if(actual == null){
            return null;
        }
        return actual.getValor();
    }
    
    // Verificar si hay página anterior
    public boolean hayAnterior(){
        return actual != null && actual.getAnterior() != null;
    }
    
    // Verificar si hay página siguiente
    public boolean haySiguiente(){
        return actual != null && actual.getProximo() != null;
    }
    
    // Mostrar todo el historial
    public String mostrarHistorial(){
        if(inicio == null){
            return "No hay páginas en el historial";
        }
        
        StringBuilder sb = new StringBuilder();
        Nodo<T> temp = inicio;
        int posicion = 1;
        
        while(temp != null){
            if(temp == actual){
                sb.append(posicion).append(". [ACTUAL] ").append(temp.getValor()).append("\n");
            } else {
                sb.append(posicion).append(". ").append(temp.getValor()).append("\n");
            }
            temp = temp.getProximo();
            posicion++;
        }
        return sb.toString();
    }
    
    public boolean esVacia(){
        return inicio == null && tam == 0;
    }
    
    public int getTam(){
        return tam;
    }
    
    public Nodo<T> getActual(){
        return actual;
    }
}
