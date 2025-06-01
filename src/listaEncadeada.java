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

    public int tamanho() {
        return tamanho;
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

    public String obterLinha() {
        StringBuilder textoFinal = new StringBuilder();
        Nodo<T> atual = primeiro;
        while (atual != null) {
            textoFinal.append(atual.dado);
            if (atual.proximo != null) textoFinal.append(" ");
            atual = atual.proximo;
        }
        return textoFinal.toString();
    }

    public boolean contem(T elemento) {
        Nodo<T> nodoAtual = primeiro;
        while (nodoAtual != null) {
            if (nodoAtual.dado.equals(elemento)) {
                return true;
            }
            nodoAtual = nodoAtual.proximo;
        }
        return false;
    }

}
