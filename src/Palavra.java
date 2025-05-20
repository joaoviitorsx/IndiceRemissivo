public class Palavra implements Comparable<Palavra> {
    private final String texto;
    private final listaEncadeada<Integer> linhas;

    public Palavra(String texto) {
        this.texto = texto.toLowerCase();
        this.linhas = new listaEncadeada<>();
    }

    public void adicionarLinha(int linha) {
        if (!linhas.contains(linha)) {
            linhas.adicionar(linha);
        }
    }

    public String getTexto() {
        return texto;
    }

    public listaEncadeada<Integer> getLinhas() {
        return linhas;
    }

    @Override
    public String toString() {
        return texto + " " + linhas.toLineString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Palavra)) return false;
        Palavra outra = (Palavra) obj;
        return this.texto.equals(outra.texto);
    }

    @Override
    public int hashCode() {
        return texto.hashCode();
    }

    @Override
    public int compareTo(Palavra outra) {
        return this.texto.compareTo(outra.texto);
    }
}
