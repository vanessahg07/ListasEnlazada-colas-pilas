package co.edu.uniquindio.escenario1_panaderia;

public class Cola <T>{

    protected Nodo<T> inicio;
    protected Nodo<T> fin;
    protected int tam;

    public Cola(){
        inicio = null;
        fin = null;
        tam = 0;
    }
    
    //Agregar Final (llegada de un nuevo cliente)
    public void agregar(T valor){
        Nodo<T> newElement = new Nodo<>(valor);
        if(inicio == null && fin == null && tam == 0){
            inicio = newElement;
            fin = newElement;
        }else{
            fin.setProximo(newElement);
            fin = newElement;
        }
        tam++;
    }
    
    //Quitar Inicio (atender al primer cliente)
    public void eliminar(){
        if(!(inicio == null && fin == null && tam == 0)){
            inicio = inicio.getProximo();
            tam--;
            if(tam == 0){
                fin = null;
            }
        }
    }
    
    //Verificar si está vacía
    public boolean isVacia(){
        boolean flag = false;
        if(inicio == null && fin == null && tam == 0){
            flag = true;
        }
        return flag;
    }
    
    //Ver el primer cliente en la cola
    public T obtenerInicio(){
        if(inicio != null){
            return inicio.getValor();
        }
        return null;
    }
    
    //Mostrar todos los clientes en la cola
    public String mostrarCola(){
        if(isVacia()){
            return "No hay clientes en la cola";
        }
        
        StringBuilder sb = new StringBuilder();
        Nodo<T> temp = inicio;
        while(temp != null){
            sb.append(temp.getValor());
            if(temp.getProximo() != null){
                sb.append(" -> ");
            }
            temp = temp.getProximo();
        }
        return sb.toString();
    }
    
    //Obtener el tamaño de la cola
    public int getTam(){
        return tam;
    }
    
    //Localizar la posición de un cliente
    public int localizar(T valor){
        Nodo<T> temp = inicio;
        int posicion = 0;
        
        while(temp != null){
            if(temp.getValor().equals(valor)){
                return posicion;
            }
            temp = temp.getProximo();
            posicion++;
        }
        return -1;
    }
}