package co.edu.uniquindio.escenario4_juego;

public class ListaCircularDoble <T>{

    private Nodo<T> actual;
    private int tam;

    public ListaCircularDoble(){
        actual = null;
        tam = 0;
    }
    
    // Agregar jugador al final (sentido de las agujas del reloj)
    public void agregarJugador(T valor){
        Nodo<T> nuevo = new Nodo<>(valor);
        
        if(actual == null && tam == 0){
            // Primer jugador, apunta a sí mismo
            actual = nuevo;
            nuevo.setProximo(actual);
            nuevo.setAnterior(actual);
        } else {
            // Buscar el último nodo (el que tiene como proximo a actual)
            Nodo<T> ultimo = actual.getAnterior();
            
            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setProximo(actual);
            actual.setAnterior(nuevo);
        }
        tam++;
    }
    
    // Avanzar al siguiente jugador
    public T siguienteTurno(){
        if(actual == null){
            return null;
        }
        actual = actual.getProximo();
        return actual.getValor();
    }
    
    // Retroceder al jugador anterior
    public T turnoAnterior(){
        if(actual == null){
            return null;
        }
        actual = actual.getAnterior();
        return actual.getValor();
    }
    
    // Ver jugador actual
    public T jugadorActual(){
        if(actual == null){
            return null;
        }
        return actual.getValor();
    }
    
    // Ver quién juega después
    public T siguienteJugador(){
        if(actual == null){
            return null;
        }
        return actual.getProximo().getValor();
    }
    
    // Ver quién jugó antes
    public T anteriorJugador(){
        if(actual == null){
            return null;
        }
        return actual.getAnterior().getValor();
    }
    
    // Expulsar un jugador por nombre
    public boolean expulsarJugador(T valor){
        if(actual == null){
            return false;
        }
        
        // Caso especial: solo un jugador
        if(tam == 1 && actual.getValor().equals(valor)){
            actual = null;
            tam--;
            return true;
        }
        
        Nodo<T> temp = actual;
        do {
            if(temp.getValor().equals(valor)){
                Nodo<T> anterior = temp.getAnterior();
                Nodo<T> proximo = temp.getProximo();
                
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                
                // Si el eliminado es el actual, mover al siguiente
                if(temp == actual){
                    actual = proximo;
                }
                
                tam--;
                return true;
            }
            temp = temp.getProximo();
        } while(temp != actual);
        
        return false;
    }
    
    // Mostrar todos los jugadores en orden circular
    public String mostrarJugadores(){
        if(actual == null){
            return "No hay jugadores en la partida";
        }
        
        StringBuilder sb = new StringBuilder();
        Nodo<T> temp = actual;
        int numero = 1;
        
        do {
            if(temp == actual){
                sb.append(numero).append(". [TURNO ACTUAL] ").append(temp.getValor()).append("\n");
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
    
    // Obtener cantidad de jugadores
    public int getTam(){
        return tam;
    }
}
