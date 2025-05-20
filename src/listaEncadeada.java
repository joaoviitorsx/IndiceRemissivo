public class listaEncadeada<T> {
    private static class Nodo<T> {
        public T dado;
        public Nodo<T> proximo;

        public Nodo(T dado){
            this.dado = dado;
            this.proximo = null;
        }
    }
    
    private Nodo<T> primeiro;
    private Nodo<T> ultimo;
    private int tamanho;

    public listaEncadeada() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void adicionar(T elemento) {
        Nodo<T> novoNodo = new Nodo<>(elemento);
        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        tamanho++;
    }

    public String toLineString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> curr = primeiro;
        while (curr != null) {
            sb.append(curr.dado);
            if (curr.proximo != null) sb.append(" ");
            curr = curr.proximo;
        }
        return sb.toString();
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean contains(T elemento) {
        Nodo<T> atual = primeiro;
        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

}
