package co.edu.uniquindio.escenario1_panaderia;

public class BiCola <T> extends Cola<T> {
    
    //Agregar cliente al inicio (para casos especiales como clientes prioritarios)
    public void agregarInicio(T valor) {
        Nodo<T> newNodo = new Nodo<>(valor);
        
        if(isVacia()){
            inicio = newNodo;
            fin = newNodo;
        }else{
            newNodo.setProximo(inicio);
            inicio = newNodo;
        }
        tam ++;
    }
    
    //Eliminar al final (para casos donde un cliente se retira de la fila)
    public void eliminarFinal(){
        if(tam == 0){
            return;
        }
        if(tam == 1){
            inicio = null;
            fin = null;
            tam = 0;
        }else{
            Nodo<T> temp = inicio;
            for(int i = 0; i < tam-2; i++){
                temp = temp.getProximo();
            }
            temp.setProximo(null);
            fin = temp;
            tam--;
        }
    }
    
    //Ver el último cliente de la cola
    public T obtenerFinal(){
        if(fin != null){
            return fin.getValor();
        }
        return null;
    }
}
