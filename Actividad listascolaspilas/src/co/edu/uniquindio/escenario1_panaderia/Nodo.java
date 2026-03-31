package co.edu.uniquindio.escenario1_panaderia;

public class Nodo <T>{
    private T valor;
    private Nodo<T> proximo;

    public Nodo(T valor) {
        this.valor = valor;
        proximo = null;
    }

    @Override
    public String toString() {
        return "Nodo {" +
                "valor = " + valor +
                ", proximo = " + proximo +
                '}';
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
}