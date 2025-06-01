import java.io.BufferedWriter;
import java.io.IOException;

public class abb {
    private class Nodo {
        public Palavra valor;
        public Nodo esquerdo, direito;

        public Nodo(Palavra valor) {
            this.valor = valor;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    private Nodo raiz;
    private int tamanho;

    public abb() {
        raiz = null;
        tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return raiz == null;
    }
    
    public void inserir(Palavra novaPalavra) {
        raiz = inserir(novaPalavra, raiz);
    }

    private Nodo inserir(Palavra nova, Nodo atual) {
        if (atual == null) {
            tamanho++;
            return new Nodo(nova);
        }

        int comp = nova.getTexto().compareTo(atual.valor.getTexto());
        if (comp < 0) {
            atual.esquerdo = inserir(nova, atual.esquerdo);
        } else if (comp > 0) {
            atual.direito = inserir(nova, atual.direito);
        } else {
            for (int i = 0; i < nova.getLinhas().tamanho(); i++) {
                atual.valor.adicionarLinha(nova.getLinhas().obterLinha().charAt(i) - '0');
            }
        }

        return atual;
    }

    public Palavra buscar(String texto) {
        return buscar(texto.toLowerCase(), raiz);
    }

    private Palavra buscar(String texto, Nodo atual) {
        if (atual == null) return null;

        int comp = texto.compareTo(atual.valor.getTexto());
        if (comp < 0) {
            return buscar(texto, atual.esquerdo);
        } else if (comp > 0) {
            return buscar(texto, atual.direito);
        } else {
            return atual.valor;
        }
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
    }

    private void imprimirEmOrdem(Nodo atual) {
        if (atual != null) {
            imprimirEmOrdem(atual.esquerdo);
            System.out.println(atual.valor); 
            imprimirEmOrdem(atual.direito);
        }
    }

    public void exportarEmOrdem(BufferedWriter bw) throws IOException {
    exportarEmOrdem(raiz, bw);
    }

    private void exportarEmOrdem(Nodo atual, BufferedWriter bw) throws IOException {
        if (atual != null) {
            exportarEmOrdem(atual.esquerdo, bw);
            bw.write(atual.valor.toString());
            bw.newLine();
            exportarEmOrdem(atual.direito, bw);
        }
    }
}
