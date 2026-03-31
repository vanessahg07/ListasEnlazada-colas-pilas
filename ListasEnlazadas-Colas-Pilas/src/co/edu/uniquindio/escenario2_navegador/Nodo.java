package co.edu.uniquindio.escenario2_navegador;

public class Nodo <T>{
    private T valor;
    private Nodo<T> proximo;
    private Nodo<T> anterior;

    public Nodo(T valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
}
